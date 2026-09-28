package com.jadaptive.sslteam.cert.api.contract.intermediate;

import jakarta.validation.constraints.NotBlank;

public record IntermediateProvisioningResponse(
        @NotBlank String requestId,
        @NotBlank String teamCode,
        @NotBlank String environment,
        @NotBlank String name,
        @NotBlank String algorithm,
        @NotBlank String status,
        @NotBlank String csrPem,
        @NotBlank String createdAtUtc,
        @NotBlank String expiresAtUtc,
        long version,
        long familyVersion) {
}
