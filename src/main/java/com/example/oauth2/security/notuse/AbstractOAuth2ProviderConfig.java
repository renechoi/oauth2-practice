// package com.example.oauth2.security.notuse;
//
// import org.springframework.security.oauth2.client.registration.ClientRegistration;
//
// public abstract class AbstractOAuth2ProviderConfig {
//
//     protected final String clientId;
//     protected final String clientSecret;
//     protected final String redirectUri;
//     protected final String tokenUri;
//     protected final String authorizationUri;
//     protected final String userInfoUri;
//     protected final String userNameAttribute;
//
//     protected AbstractOAuth2ProviderConfig(String clientId, String clientSecret, String redirectUri, String tokenUri,
//                                            String authorizationUri, String userInfoUri, String userNameAttribute) {
//         this.clientId = clientId;
//         this.clientSecret = clientSecret;
//         this.redirectUri = redirectUri;
//         this.tokenUri = tokenUri;
//         this.authorizationUri = authorizationUri;
//         this.userInfoUri = userInfoUri;
//         this.userNameAttribute = userNameAttribute;
//     }
//
//     protected abstract ClientRegistration.Builder getBuilder(String registrationId);
// }
