package com.example.oauth2.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

	private final Environment environment;
	private final String registration = "spring.security.oauth2.client.registration.";

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeRequests(
				authorize -> authorize.antMatchers("/login", "/index")
					.permitAll().anyRequest().authenticated())
			.oauth2Login(Customizer.withDefaults())

			.oauth2Login(oauth2 -> oauth2
				.clientRegistrationRepository(clientRegistrationRepository())
				.authorizedClientService(oAuth2AuthorizedClientService()))
			.build();

	}

	@Bean
	public OAuth2AuthorizedClientService oAuth2AuthorizedClientService() {
		return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
	}

	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		List<ClientRegistration> clientRegistrations = Arrays.asList(
			googleClientRegistration(), facebookClientRegistration(),kakaoClientRegistration()
		);
		return new InMemoryClientRegistrationRepository(clientRegistrations);
	}


	private ClientRegistration googleClientRegistration() {
		final String clientId = environment.getProperty(registration + "google.client-id");
		final String clientSecret = environment.getProperty(registration + "google.client-secret");

		return CommonOAuth2Provider
			.GOOGLE.getBuilder("google")
			.clientId(clientId)
			.scope("public_profile", "email","user_birthday","user_gender")
			.userInfoUri("https://graph.facebook.com/me?fields=id,name,email,public_profile,user_birthday,user_gender")
			.clientSecret(clientSecret)
			.build();
	}

	private ClientRegistration facebookClientRegistration() {
		final String clientId = environment.getProperty(registration + "facebook.client-id");
		final String clientSecret = environment.getProperty(registration + "facebook.client-secret");

		return CommonOAuth2Provider
			.FACEBOOK.getBuilder("facebook")
			.clientId(clientId)
			.clientSecret(clientSecret)
			.build();
	}


	private ClientRegistration kakaoClientRegistration() {
		final String clientId = environment.getProperty(registration + "kakao.client-id");
		final String clientSecret = environment.getProperty(registration + "kakao.client-secret");

		return ClientRegistration.withRegistrationId("kakao")
			.clientId(clientId)
			.clientSecret(clientSecret)
			.clientAuthenticationMethod(ClientAuthenticationMethod.POST)
			.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
			.redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
			.scope("profile_image")
			.authorizationUri("https://kauth.kakao.com/oauth/authorize")
			.tokenUri("https://kauth.kakao.com/oauth/token")
			.userInfoUri("https://kapi.kakao.com/v2/user/me")
			.userNameAttributeName("id")
			.build();
	}


}


