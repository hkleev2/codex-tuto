package com.example.codextuto.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getOrCreate(Provider provider, String providerId, String displayName) {
        Optional<User> user = userRepository.findByProviderAndProviderId(provider, providerId);
        return user.orElseGet(() -> userRepository.save(provider, providerId, displayName));
    }
}
