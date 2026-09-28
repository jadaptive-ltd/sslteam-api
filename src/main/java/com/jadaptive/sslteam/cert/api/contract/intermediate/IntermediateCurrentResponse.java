package com.jadaptive.sslteam.cert.api.contract.intermediate;

import jakarta.validation.constraints.NotBlank;

public record IntermediateCurrentResponse(
        @NotBlank String environment,
        @NotBlank String status,
        String intermediateId,
        String name,
        String subjectDn,
        String fingerprintSha256,
        String serialNumber,
        String notBeforeUtc,
        String activatedAtUtc,
        String notAfterUtc,
        Long version,
        Long familyVersion) {

    public static IntermediateCurrentResponse notConfigured(String environment) {
        return notConfigured(environment, null);
    }

    public static IntermediateCurrentResponse notConfigured(String environment, Long familyVersion) {
        return new IntermediateCurrentResponse(
            environment, "NOT_CONFIGURED", null, null, null, null, null, null, null, null, null, familyVersion);
    }
}
