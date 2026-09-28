package com.jadaptive.sslteam.cert.api.contract.scope;

import java.util.Locale;

public record PkiScope(String team, String environment) {

    public static final String DEFAULT_TEAM = "default";
    public static final String DEFAULT_ENVIRONMENT = "default";

    public PkiScope {
        team = normalize(team, "team", DEFAULT_TEAM);
        environment = normalize(environment, "environment", DEFAULT_ENVIRONMENT);
    }

    public static PkiScope defaults() {
        return new PkiScope(DEFAULT_TEAM, DEFAULT_ENVIRONMENT);
    }

    private static String normalize(String value, String field, String defaultValue) {
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        if (normalized.contains("..")
                || !normalized.matches("[a-z0-9][a-z0-9._-]{0,62}[a-z0-9]")) {
            throw new IllegalArgumentException(field + " must match [a-z0-9][a-z0-9._-]{0,62}[a-z0-9]");
        }
        return normalized;
    }
}
