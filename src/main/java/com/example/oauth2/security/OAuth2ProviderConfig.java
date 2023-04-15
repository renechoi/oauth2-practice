package com.example.oauth2.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import com.example.oauth2.security.provider.GoogleOAuth2Provider;
import com.example.oauth2.security.provider.KakaoOAuth2Provider;
import com.example.oauth2.security.provider.NaverOAuth2Provider;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class OAuth2ProviderConfig {

	private final GoogleOAuth2Provider googleOAuth2Provider;
	private final KakaoOAuth2Provider kakaoOAuth2Provider;
	private final NaverOAuth2Provider naverOAuth2Provider;

	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		List<ClientRegistration> clientRegistrations = Arrays.asList(
			googleOAuth2Provider.getClientRegistration(),
			kakaoOAuth2Provider.getClientRegistration(),
			naverOAuth2Provider.getClientRegistration()
		);
		return new InMemoryClientRegistrationRepository(clientRegistrations);
	}

	@Bean
	public OAuth2AuthorizedClientService oAuth2AuthorizedClientService() {
		return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
	}

	// private ClientRegistration googleClientRegistration() {
	//
	// 	return CommonOAuth2Provider.GOOGLE.getBuilder("google")
	// 		.clientId(googleClientId)
	// 		// .scope("profile", "email")
	// 		.userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
	// 		.clientSecret(googleClientSecret)
	// 		.build();
	// }
	//
	// private ClientRegistration kakaoClientRegistration() {
	//
	// 	return ClientRegistration.withRegistrationId("kakao")
	// 		.clientId(kakaoClientId)
	// 		.clientSecret(kakaoClientSecret)
	// 		.clientAuthenticationMethod(ClientAuthenticationMethod.POST)
	// 		.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
	// 		.redirectUri(kakaoRedirectUri)
	// 		// .scope("profile_image")
	// 		.authorizationUri(kakaoAuthorizationUri)
	// 		.tokenUri(kakaoTokenUri)
	// 		.userInfoUri(kakaoUserInfoUri)
	// 		.userNameAttributeName(kakaoUserNameAttribute)
	// 		.build();
	// }
	//
	// private ClientRegistration naverClientRegistration() {
	//
	// 	return ClientRegistration.withRegistrationId("naver")
	// 		.clientId(naverClientId)
	// 		.clientSecret(naverClientSecret)
	// 		.clientAuthenticationMethod(ClientAuthenticationMethod.POST)
	// 		.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
	// 		.redirectUri(naverRedirectUri)
	// 		// .scope("name", "email", "profile_image")
	// 		.authorizationUri(naverAuthorizationUri)
	// 		.tokenUri(naverTokenUri)
	// 		.userInfoUri(naverUserInfoUri)
	// 		.userNameAttributeName(naverUserNameAttribute)
	// 		.build();
	// }
}






