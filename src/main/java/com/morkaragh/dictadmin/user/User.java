package com.morkaragh.dictadmin.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import static java.util.Objects.requireNonNull;

public class User {

    private final OAuth2AuthenticationToken oAuth2AuthenticationToken;

    public User(Authentication oAuth2AuthenticationToken) {
        this.oAuth2AuthenticationToken = (OAuth2AuthenticationToken) oAuth2AuthenticationToken;
    }

    public String getFullName() {
        return oAuth2AuthenticationToken.getPrincipal().getAttribute("name");
    }

    public String getShortName() {
        String givenName = oAuth2AuthenticationToken.getPrincipal().getAttribute("given_name");
        String familyName = oAuth2AuthenticationToken.getPrincipal().getAttribute("family_name");
        return familyName + " " + requireNonNull(givenName).charAt(0) + ".";
    }
}
