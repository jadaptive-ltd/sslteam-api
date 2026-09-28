package com.jadaptive.sslteam.cert.api.contract.leaf;

import java.time.Instant;
import java.util.UUID;

public record LeafRevokeResponse(
        UUID issuanceId,
        LeafStatus status,
        Instant revokedAt,
        long version) {
}
