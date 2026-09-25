package com.sslteam.cert.api.contract.intermediate;

import com.sslteam.cert.api.contract.leaf.LeafSummary;
import java.util.List;

public record IntermediateHistoryItem(
        String intermediateId,
        String name,
        String status,
        String subjectDn,
        String fingerprintSha256,
        String notBeforeUtc,
        String activatedAtUtc,
        String notAfterUtc,
        String revokedAtUtc,
        String revokeReason,
        String retiredAtUtc,
        String retireReason,
        long version,
        List<LeafSummary> signedLeafCertificates) {

    public IntermediateHistoryItem {
        signedLeafCertificates = signedLeafCertificates == null ? List.of() : List.copyOf(signedLeafCertificates);
    }
}
