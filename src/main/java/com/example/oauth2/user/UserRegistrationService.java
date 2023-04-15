package com.example.oauth2.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

	private final UserFindService userFindService;
	private final UserRepository userRepository;

	public void requestRegistration(final String name, final String email) {

		final boolean exists = userFindService.existsByEmail(email);

		if (!exists) {
			final User user = new User(name, email);
			userRepository.save(user);
		}
	}
}
