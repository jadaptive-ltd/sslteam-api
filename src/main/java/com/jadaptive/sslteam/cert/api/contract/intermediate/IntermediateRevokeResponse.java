package com.jadaptive.sslteam.cert.api.contract.intermediate;

import java.time.Instant;
import java.util.UUID;

public record IntermediateRevokeResponse(
        UUID intermediateId,
        IntermediateStatus status,
        Instant revokedAt,
        long version,
        long familyVersion) {
}
