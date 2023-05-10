package com.mai.journal.Domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, LECTURER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
