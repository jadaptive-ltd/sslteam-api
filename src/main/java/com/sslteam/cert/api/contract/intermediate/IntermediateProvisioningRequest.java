package com.sslteam.cert.api.contract.intermediate;

import jakarta.validation.constraints.NotBlank;

public record IntermediateProvisioningRequest(
        @NotBlank String teamCode,
        String environment,
        @NotBlank String name,
        @NotBlank String algorithm,
        @NotBlank String subjectDn) {
}
