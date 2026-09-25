package com.sslteam.cert.api.contract.leaf;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LeafSan(
        @NotNull LeafSanType type,
        @NotBlank String value) {

    public LeafSan(String type, String value) {
        this(LeafSanType.fromCode(type), value);
    }
}
