package com.sslteam.cert.api.contract.root;

import com.sslteam.cert.api.contract.family.CaCustodyMode;
import com.sslteam.cert.api.contract.family.PkiFamilyStatus;
import com.sslteam.cert.api.contract.scope.PkiScope;
import java.time.Instant;
import java.util.UUID;

public record RootCertificateResponse(
        PkiScope scope,
        UUID rootId,
        String subjectDn,
        String serialNumber,
        PkiFamilyStatus familyStatus,
        CaCustodyMode custodyMode,
        String certificatePem,
        String fingerprintSha256,
        Instant notBefore,
        Instant notAfter,
        long version,
        long familyVersion,
        boolean privateKeyDeliveryPending,
        Instant retiredAt,
        String retireReason,
        Instant revokedAt,
        String revokeReason) {
}
