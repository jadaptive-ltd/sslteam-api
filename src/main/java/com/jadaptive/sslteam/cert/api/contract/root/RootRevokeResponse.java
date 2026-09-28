package com.jadaptive.sslteam.cert.api.contract.root;

import com.jadaptive.sslteam.cert.api.contract.family.PkiFamilyStatus;
import java.time.Instant;
import java.util.UUID;

public record RootRevokeResponse(
        UUID rootId,
        PkiFamilyStatus familyStatus,
        Instant revokedAt,
        long rootVersion,
        long familyVersion) {
}
