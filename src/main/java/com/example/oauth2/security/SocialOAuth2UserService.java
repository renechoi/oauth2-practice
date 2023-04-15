package com.example.oauth2.security;

import java.util.Map;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.oauth2.user.UserRegistrationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SocialOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	private final UserRegistrationService userRegistrationService;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		String clientRegistrationId = userRequest.getClientRegistration().getRegistrationId();
		OAuth2UserService<OAuth2UserRequest, OAuth2User> userService = new DefaultOAuth2UserService();

		OAuth2User oAuth2User = userService.loadUser(userRequest);

		if (clientRegistrationId.equals("google")) {

			System.out.println("google oAuth2User = " + oAuth2User);
			String name = oAuth2User.getAttributes().get("name").toString();
			String email = oAuth2User.getAttributes().get("email").toString();
			userRegistrationService.requestRegistration(name, email);
			return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "sub");


		} else if (clientRegistrationId.equals("kakao")) {
			Map<String, Object> properties = (Map<String, Object>)oAuth2User.getAttributes().get("properties");
			Map<String, Object> kakaoAccount = (Map<String, Object>)oAuth2User.getAttributes().get("kakao_account");
			String name = properties.get("nickname").toString();
			String email = kakaoAccount.get("email").toString();
			userRegistrationService.requestRegistration(name, email);
		} else if (clientRegistrationId.equals("naver")) {

			Map<String, Object> attributes = (Map<String, Object>)oAuth2User.getAttributes().get("response");
			System.out.println("attributes = " + attributes);

			String name = attributes.get("name").toString();
			String email = attributes.get("email").toString();
			String nickname = attributes.get("nickname").toString();
			String profileImage = attributes.get("profile_image").toString();
			userRegistrationService.requestRegistration(name, email);
			return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "response");
		}

		return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "id");
	}
}
