package com.jadaptive.sslteam.cert.api.audit;

import java.util.List;
import java.util.UUID;

public record CertificateAuditHistoryResponse(
        UUID resourceId,
        CertificateAuditResourceType resourceType,
        List<CertificateAuditEntry> items,
        boolean truncated) {

    public CertificateAuditHistoryResponse {
        items = List.copyOf(items);
    }
}
