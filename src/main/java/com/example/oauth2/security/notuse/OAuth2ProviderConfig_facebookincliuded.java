// package com.example.oauth2.security.notuse;
//
// import java.util.Arrays;
// import java.util.List;
//
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.env.Environment;
// import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
// import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
// import org.springframework.security.oauth2.client.registration.ClientRegistration;
// import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
// import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
// import org.springframework.security.oauth2.core.AuthorizationGrantType;
// import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//
// import com.example.oauth2.security.notuse.GoogleOAuth2UserService;
// import com.example.oauth2.security.SocialOAuth2UserService;
//
// import lombok.RequiredArgsConstructor;
//
// @Configuration
// @RequiredArgsConstructor
// public class OAuth2ProviderConfig_facebookincliuded {
//
// 	private final Environment environment;
//
// 	@Value("${spring.security.oauth2.client.registration.google.client-id}")
// 	private String googleClientId;
//
// 	@Value("${spring.security.oauth2.client.registration.google.client-secret}")
// 	private String googleClientSecret;
//
// 	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
// 	private String kakaoClientId;
//
// 	@Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
// 	private String kakaoClientSecret;
//
// 	@Value("${spring.security.oauth2.client.registration.naver.client-id}")
// 	private String naverClientId;
//
// 	@Value("${spring.security.oauth2.client.registration.naver.client-secret}")
// 	private String naverClientSecret;
//
// 	private final GoogleOAuth2UserService googleOAuth2UserService;
// 	private final SocialOAuth2UserService socialOAuth2UserService;
//
// 	public GoogleOAuth2UserService googleOAuth2UserService() {
// 		return googleOAuth2UserService;
// 	}
//
// 	public SocialOAuth2UserService socialOAuth2UserService() {
// 		return socialOAuth2UserService;
// 	}
//
// 	@Bean
// 	public ClientRegistrationRepository clientRegistrationRepository() {
// 		List<ClientRegistration> clientRegistrations = Arrays.asList(googleClientRegistration(),
// 			kakaoClientRegistration(), naverClientRegistration());
// 		return new InMemoryClientRegistrationRepository(clientRegistrations);
// 	}
//
// 	@Bean
// 	public OAuth2AuthorizedClientService oAuth2AuthorizedClientService() {
// 		return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
// 	}
//
// 	private ClientRegistration googleClientRegistration() {
//
// 		return CommonOAuth2Provider.GOOGLE.getBuilder("google")
// 			.clientId(googleClientId)
// 			.scope("public_profile", "email", "user_birthday", "user_gender")
// 			.userInfoUri("https://graph.facebook.com/me?fields=id,name,email,public_profile,user_birthday,user_gender")
// 			.clientSecret(googleClientSecret)
// 			.build();
// 	}
//
// 	// private ClientRegistration facebookClientRegistration() {
// 	// 	final String clientId = environment.getProperty(REGISTRATION + "facebook.client-id");
// 	// 	final String clientSecret = environment.getProperty(REGISTRATION + "facebook.client-secret");
// 	//
// 	// 	return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook")
// 	// 		.clientId(clientId)
// 	// 		.clientSecret(clientSecret)
// 	// 		.build();
// 	// }
//
// 	private ClientRegistration kakaoClientRegistration() {
//
// 		return ClientRegistration.withRegistrationId("kakao")
// 			.clientId(kakaoClientId)
// 			.clientSecret(kakaoClientSecret)
// 			.clientAuthenticationMethod(ClientAuthenticationMethod.POST)
// 			.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
// 			.redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
// 			.scope("profile_image")
// 			.authorizationUri("https://kauth.kakao.com/oauth/authorize")
// 			.tokenUri("https://kauth.kakao.com/oauth/token")
// 			.userInfoUri("https://kapi.kakao.com/v2/user/me")
// 			.userNameAttributeName("id")
// 			.build();
// 	}
//
// 	private ClientRegistration naverClientRegistration() {
//
// 		return ClientRegistration.withRegistrationId("naver")
// 			.clientId(naverClientId)
// 			.clientSecret(naverClientSecret)
// 			.clientAuthenticationMethod(ClientAuthenticationMethod.POST)
// 			.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
// 			.redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
// 			.scope("name", "email", "profile_image")
// 			.authorizationUri("https://nid.naver.com/oauth2.0/authorize")
// 			.tokenUri("https://nid.naver.com/oauth2.0/token")
// 			.userInfoUri("https://openapi.naver.com/v1/nid/me")
// 			.userNameAttributeName("response")
// 			.clientName("Naver")
// 			.build();
// 	}
// }
