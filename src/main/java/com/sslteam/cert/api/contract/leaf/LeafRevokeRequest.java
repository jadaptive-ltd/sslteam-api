package com.sslteam.cert.api.contract.leaf;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record LeafRevokeRequest(
        @NotNull @PositiveOrZero Long expectedVersion,
        String reason) {
}
