package com.sslteam.cert.api.contract.root;

import com.sslteam.cert.api.contract.scope.PkiScope;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record RootRevokeRequest(
        @NotNull PkiScope scope,
        @NotNull @PositiveOrZero Long expectedVersion,
        @NotNull @PositiveOrZero Long expectedFamilyVersion,
                @Size(max = 256) String reason) {

        public RootRevokeRequest {
                scope = scope == null ? PkiScope.defaults() : scope;
        }
}
