package com.jadaptive.sslteam.cert.api.contract.intermediate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record IntermediateRetireRequest(
        @NotNull @PositiveOrZero Long expectedVersion,
        @NotNull @PositiveOrZero Long expectedFamilyVersion,
        @Size(max = 256) String reason) {
}
