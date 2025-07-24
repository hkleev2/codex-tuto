package com.example.codextuto.user;

public class User {
    private final Long id;
    private final Provider provider;
    private final String providerId;
    private final String displayName;

    public User(Long id, Provider provider, String providerId, String displayName) {
        this.id = id;
        this.provider = provider;
        this.providerId = providerId;
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public Provider getProvider() {
        return provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public String getDisplayName() {
        return displayName;
    }
}
