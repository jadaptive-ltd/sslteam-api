package com.jadaptive.sslteam.cert.api.contract.root;

import com.jadaptive.sslteam.cert.api.contract.scope.PkiScope;
import java.util.Objects;

public record RootCaSetupRequest(
        PkiScope scope,
        String commonName,
        String organization,
        String organizationalUnit) {

    public RootCaSetupRequest {
    scope = scope == null ? PkiScope.defaults() : scope;
        commonName = Objects.requireNonNullElse(commonName, "").trim();
        organization = normalizeOptional(organization);
        organizationalUnit = normalizeOptional(organizationalUnit);
        if (commonName.isBlank()) {
            throw new IllegalArgumentException("commonName is required");
        }
        if (commonName.length() > 200) {
            throw new IllegalArgumentException("commonName must be at most 200 characters");
        }
    }

    private static String normalizeOptional(String value) {
        return Objects.requireNonNullElse(value, "").trim();
    }
}
