package com.sslteam.cert.api.audit;

import java.time.Instant;
import java.util.UUID;

public record CertificateAuditEntry(
        UUID eventId,
        Instant occurredAt,
        String teamCode,
        String environment,
        UUID actorUserId,
        CertificateAuditEventType eventType,
        CertificateAuditResult result,
        CertificateAuditResourceType resourceType,
        UUID resourceId,
        String resourceKey,
        String reasonCode,
        String correlationId,
        String reason) {
}
