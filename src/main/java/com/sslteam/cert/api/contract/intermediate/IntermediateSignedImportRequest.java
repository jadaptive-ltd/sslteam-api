package com.sslteam.cert.api.contract.intermediate;

import jakarta.validation.constraints.NotBlank;

public record IntermediateSignedImportRequest(
        @NotBlank String intermediateCertPem,
        @NotBlank String chainPem,
        Long expectedRequestVersion,
        Long expectedActiveVersion,
        Long expectedFamilyVersion) {
}
