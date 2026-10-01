package com.jadaptive.sslteam.auth.api;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record CurrentUserResponse(
        UUID id,
        String username,
        String displayName,
        String email,
        String status,
        List<String> roleCodes,
        Set<String> permissions,
        boolean protectedAccount) {
}