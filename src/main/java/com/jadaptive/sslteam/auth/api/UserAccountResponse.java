package com.jadaptive.sslteam.auth.api;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record UserAccountResponse(
        UUID id,
        long version,
        String username,
        String displayName,
        String email,
        String status,
        Instant createdAt,
        Instant updatedAt,
        List<String> roleCodes,
        boolean protectedAccount) {
}