package com.example.codextuto.user;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Optional<User> findByProviderAndProviderId(Provider provider, String providerId) {
        return Optional.ofNullable(users.get(key(provider, providerId)));
    }

    public User save(Provider provider, String providerId, String displayName) {
        long id = idGenerator.incrementAndGet();
        User user = new User(id, provider, providerId, displayName);
        users.put(key(provider, providerId), user);
        return user;
    }

    private String key(Provider provider, String providerId) {
        return provider.name() + "|" + providerId;
    }
}
