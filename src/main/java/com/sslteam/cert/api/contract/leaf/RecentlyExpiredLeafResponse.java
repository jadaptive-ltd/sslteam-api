package com.sslteam.cert.api.contract.leaf;

public record RecentlyExpiredLeafResponse(
        LeafSummary certificate,
        CertificateAttentionType attentionType,
        CertificateAttentionState attentionState,
        long attentionVersion) {
}