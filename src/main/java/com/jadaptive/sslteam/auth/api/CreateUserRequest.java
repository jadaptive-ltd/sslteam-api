package com.jadaptive.sslteam.auth.api;

public record CreateUserRequest(String username, String displayName, String email, String roleCode) {
}