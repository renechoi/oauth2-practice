package com.example.oauth2.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
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

	private final OAuth2ProviderConfig oAuth2ProviderConfig;
	private final SocialOAuth2UserService socialOAuth2UserService;


	// @Value("${spring.security.oauth2.client.registration.naver.client-id}")
	// private String naverClientId;
	//
	// @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
	// private String naverClientSecret;

	//
	// @Bean
	// SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
	// 	return httpSecurity.authorizeRequests(
	// 			authorize -> authorize.antMatchers("/login", "/index").permitAll().anyRequest().authenticated())
	// 		.oauth2Login(Customizer.withDefaults())
	//
	// 		.oauth2Login(oauth2 -> oauth2.clientRegistrationRepository(clientRegistrationRepository())
	// 			.authorizedClientService(oAuth2AuthorizedClientService())
	// 			.userInfoEndpoint(
	// 				user -> user.oidcUserService(googleOAuth2UserService)  // google 인증 -> OpenId Connect 1.0
	// 					.userService(socialOAuth2UserService)        // facebook 인증, OAuth2 통신
	// 			))
	//
	// 		.build();
	//
	// }


	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeRequests(
				authorize -> authorize.antMatchers("/login", "/index").permitAll().anyRequest().authenticated())
			.oauth2Login(Customizer.withDefaults())

			.oauth2Login(oauth2 -> oauth2.clientRegistrationRepository(oAuth2ProviderConfig.clientRegistrationRepository())
				.authorizedClientService(oAuth2ProviderConfig.oAuth2AuthorizedClientService())
				.userInfoEndpoint(
					user -> user
						.userService(socialOAuth2UserService)
				))
			.build();
	}


}


