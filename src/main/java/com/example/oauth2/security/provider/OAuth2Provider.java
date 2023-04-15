package com.example.oauth2.security.provider;

import org.springframework.security.oauth2.client.registration.ClientRegistration;

public abstract class OAuth2Provider {
	protected String clientId;
	protected String clientSecret;
	protected String redirectUri;
	protected String tokenUri;
	protected String authorizationUri;
	protected String userInfoUri;
	protected String userNameAttribute;

	public abstract ClientRegistration getClientRegistration();

	// getters and setters
}