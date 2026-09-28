package com.jadaptive.sslteam.cert.api.contract.leaf;

import java.util.UUID;

public record LeafAttentionUpdateResponse(
        UUID issuanceId,
        CertificateAttentionType attentionType,
        CertificateAttentionState state,
        long version) {
}