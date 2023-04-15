// package com.example.oauth2.security.notuse;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
// import org.springframework.security.oauth2.client.registration.ClientRegistration;
//
// @Configuration
// public class GoogleOAuth2ProviderConfig extends SocialOAuth2ProviderConfig {
//
//     @Value("${spring.security.oauth2.client.registration.google.client-id}")
//     private String clientId;
//
//     @Value("${spring.security.oauth2.client.registration.google.client-secret}")
//     private String clientSecret;
//
//     @Override
//     protected ClientRegistration.Builder getBuilder() {
//         return CommonOAuth2Provider.GOOGLE.getBuilder("google")
//                 .clientId(clientId)
//                 .clientSecret(clientSecret)
//                 .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo");
//     }
// }
