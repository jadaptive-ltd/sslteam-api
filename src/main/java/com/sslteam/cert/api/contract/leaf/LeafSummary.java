package com.sslteam.cert.api.contract.leaf;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record LeafSummary(
        UUID id,
        UUID issuanceId,
        String environment,
        String name,
        UUID intermediateId,
        String subjectDn,
        List<LeafSan> sans,
        String keyAlgorithm,
        String serialNumber,
        String fingerprintSha256,
        Instant notBefore,
        Instant notAfter,
        String status,
        Instant createdAt,
        long version,
        Instant revokedAt,
        String revokeReason) {
}
