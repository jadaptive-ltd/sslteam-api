package com.sslteam.cert.api.contract.root;

import com.sslteam.cert.api.contract.family.PkiFamilyStatus;
import com.sslteam.cert.api.contract.scope.PkiScope;
import java.time.Instant;
import java.util.UUID;

public record RootCaSetupResponse(
        PkiScope scope,
        UUID rootId,
        PkiFamilyStatus familyStatus,
        ApplicationCaSetupState setupState,
        String rootCertificatePem,
        String intermediateCertificatePem,
        String rootPrivateKeyPem,
        String rootFingerprintSha256,
        String intermediateFingerprintSha256,
        Instant rootNotBefore,
        Instant rootNotAfter,
        Instant intermediateNotBefore,
        Instant intermediateNotAfter,
        long familyVersion,
        long rootVersion,
        long intermediateVersion,
        boolean leafIssuanceReady) {

    public RootCaSetupResponse {
        if (scope == null || rootId == null || familyStatus == null || setupState == null) {
            throw new IllegalArgumentException("scope, rootId, familyStatus, and setupState are required");
        }
        requirePem(rootCertificatePem, "rootCertificatePem");
        requirePem(intermediateCertificatePem, "intermediateCertificatePem");
        requirePem(rootPrivateKeyPem, "rootPrivateKeyPem");
        requireText(rootFingerprintSha256, "rootFingerprintSha256");
        requireText(intermediateFingerprintSha256, "intermediateFingerprintSha256");
        if (rootNotBefore == null || rootNotAfter == null
            || intermediateNotBefore == null || intermediateNotAfter == null) {
            throw new IllegalArgumentException("certificate validity is required");
        }
        if (familyVersion < 0 || rootVersion < 0 || intermediateVersion < 0) {
            throw new IllegalArgumentException("versions must be non-negative");
        }
        if (setupState == ApplicationCaSetupState.COMPLETED && !leafIssuanceReady) {
            throw new IllegalArgumentException("completed setup must enable leaf issuance");
        }
        if (setupState != ApplicationCaSetupState.COMPLETED && leafIssuanceReady) {
            throw new IllegalArgumentException("incomplete setup cannot enable leaf issuance");
        }
    }

    private static void requirePem(String value, String field) {
        requireText(value, field);
        if (!value.contains("-----BEGIN CERTIFICATE-----") && !value.contains("-----BEGIN PRIVATE KEY-----")) {
            throw new IllegalArgumentException(field + " must be PEM encoded");
        }
    }

    private static void requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " is required");
        }
    }
}
