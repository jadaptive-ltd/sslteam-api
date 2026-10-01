package com.jadaptive.sslteam.auth.api;

public record UpdateUserRequest(long expectedVersion, String displayName, String email, String status) {
}