package com.sslteam.cert.api.contract.intermediate;

import jakarta.validation.constraints.NotBlank;

public record IntermediatePendingRequestSummary(
        @NotBlank String requestId,
        @NotBlank String environment,
        @NotBlank String name,
        @NotBlank String algorithm,
        @NotBlank String status,
        @NotBlank String createdAtUtc,
        @NotBlank String expiresAtUtc,
        long version) {
}
