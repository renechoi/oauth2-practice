// package com.example.oauth2.security.notuse;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.oauth2.client.registration.ClientRegistration;
// import org.springframework.security.oauth2.core.AuthorizationGrantType;
// import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//
// @Configuration
// public class KakaoOAuth2ProviderConfig extends SocialOAuth2ProviderConfig {
//
//     @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
//     private String clientId;
//
//     @Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
//     private String clientSecret;
//
//     @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
//     private String redirectUri;
//
//     @Value("${spring.security.oauth2.client.provider.kakao.token-uri}")
//     private String tokenUri;
//
//     @Value("${spring.security.oauth2.client.provider.kakao.authorization-uri}")
//     private String authorizationUri;
//
//     @Value("${spring.security.oauth2.client.provider.kakao.user-info-uri}")
//     private String userInfoUri;
//
//     @Value("${spring.security.oauth2.client.provider.kakao.user-name-attribute}")
//     private String userNameAttribute;
//
//     @Override
//     protected ClientRegistration.Builder getBuilder() {
//         return ClientRegistration.withRegistrationId("kakao")
//                 .clientId(clientId)
//                 .clientSecret(clientSecret)
//                 .clientAuthenticationMethod(ClientAuthenticationMethod.POST)
//                 .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                 .redirectUri(redirectUri)
//                 .authorizationUri(authorizationUri)
//                 .tokenUri(tokenUri)
//                 .userInfoUri(userInfoUri)
//                 .userNameAttributeName(userNameAttribute);
//     }
// }
