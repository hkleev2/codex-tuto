package com.example.codextuto.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/me")
    public Object me(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            return null;
        }
        return principal.getAttributes();
    }
}
