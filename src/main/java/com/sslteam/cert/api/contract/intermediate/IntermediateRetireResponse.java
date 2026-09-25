package com.sslteam.cert.api.contract.intermediate;

import java.time.Instant;
import java.util.UUID;

public record IntermediateRetireResponse(
        UUID intermediateId,
        IntermediateStatus status,
        Instant retiredAt,
        long version,
        long familyVersion) {
}
