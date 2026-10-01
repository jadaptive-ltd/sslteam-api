package com.jadaptive.sslteam.auth.api;

public record DeleteUserRequest(long expectedVersion, String reason) {
}