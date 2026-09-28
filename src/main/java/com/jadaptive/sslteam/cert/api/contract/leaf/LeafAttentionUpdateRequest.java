package com.jadaptive.sslteam.cert.api.contract.leaf;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record LeafAttentionUpdateRequest(
        @NotNull @PositiveOrZero Long expectedVersion,
        @NotNull CertificateAttentionState state) {
}