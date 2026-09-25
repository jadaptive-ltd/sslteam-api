package com.sslteam.cert.api.contract.leaf;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LeafArtifactDownloadRequest(
        @NotBlank String outputProfile,
        @Size(max = 256) String pkcs12Password) {
}
