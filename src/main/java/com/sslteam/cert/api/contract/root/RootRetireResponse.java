package com.sslteam.cert.api.contract.root;

import com.sslteam.cert.api.contract.family.PkiFamilyStatus;
import java.time.Instant;
import java.util.UUID;

public record RootRetireResponse(
        UUID rootId,
        PkiFamilyStatus familyStatus,
        Instant retiredAt,
        long rootVersion,
        long familyVersion) {
}
