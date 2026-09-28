package com.jadaptive.sslteam.cert.api.contract.intermediate;

import jakarta.validation.constraints.NotBlank;

public record IntermediateSignedImportResponse(
        @NotBlank String requestId,
        @NotBlank String intermediateId,
        @NotBlank String status,
        @NotBlank String activatedAtUtc,
        @NotBlank String fingerprintSha256,
        long requestVersion,
        long intermediateVersion,
        long familyVersion) {
}
