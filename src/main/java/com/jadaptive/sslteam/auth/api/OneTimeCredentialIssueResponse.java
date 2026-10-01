package com.jadaptive.sslteam.auth.api;

import java.time.Instant;
import java.util.UUID;

public record OneTimeCredentialIssueResponse(
        UUID userId,
        String username,
        String credentialState,
        String oneTimeCredential,
        Instant credentialIssuedAt,
        Instant credentialExpiresAt,
        boolean passwordChangeRequired) {
}