// package com.example.oauth2.security.notuse;
//
// import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
// import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
// import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
// import org.springframework.security.oauth2.core.OAuth2AccessToken;
// import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
// import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
// import org.springframework.security.oauth2.core.oidc.user.OidcUser;
// import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.stereotype.Service;
//
// import com.example.oauth2.user.UserRegistrationService;
//
// import lombok.RequiredArgsConstructor;
//
// @Service
// @RequiredArgsConstructor
// public class GoogleOAuth2UserService implements OAuth2UserService<OidcUserRequest, OidcUser> {
// 	private final UserRegistrationService userRegistrationService;
//
// 	@Override
// 	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
//
// 		final OidcUserService oidcUserService = new OidcUserService();
// 		OidcUser oidcUser = oidcUserService.loadUser(userRequest);
// 		OAuth2AccessToken accessToken = userRequest.getAccessToken();
//
// 		String name = oidcUser.getAttributes().get("name").toString();
// 		String email = oidcUser.getAttributes().get("email").toString();
//
// 		userRegistrationService.requestRegistration(name, email);
//
// 		System.out.println("email = " + email);
//
// 		return new DefaultOidcUser(
// 			oidcUser.getAuthorities(),oidcUser.getIdToken(), oidcUser.getUserInfo()
// 		);
// 	}
// }
