package com.jadaptive.sslteam.auth.api;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/** Canonical built-in roles and their stable wire codes. */
public enum BuiltInRole {

    ADMIN("role_admin", "Administrator", "Full SSLTeam administration"),
    OPERATOR("role_operator", "Operator", "User creation and non-destructive certificate operations"),
    VIEWER("role_viewer", "Viewer", "Read-only certificate access");

    private static final Set<String> CODES = Arrays.stream(values())
            .map(BuiltInRole::code)
            .collect(Collectors.toUnmodifiableSet());

    private final String code;
    private final String displayName;
    private final String description;

    BuiltInRole(String code, String displayName, String description) {
        this.code = code;
        this.displayName = displayName;
        this.description = description;
    }

    public String code() {
        return code;
    }

    public String displayName() {
        return displayName;
    }

    public String description() {
        return description;
    }

    public static BuiltInRole fromCode(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("roleCode is required");
        }
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        return Arrays.stream(values())
                .filter(role -> role.code.equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "roleCode must be one of the built-in roles: " + CODES));
    }

    public static BuiltInRole fromCliValue(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("role is required");
        }
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        return Arrays.stream(values())
                .filter(role -> role.code.equals(normalized)
                        || role.name().toLowerCase(Locale.ROOT).equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "role must be one of the built-in roles: " + CODES));
    }

    public static boolean isBuiltInCode(String value) {
        return value != null && CODES.contains(value.trim().toLowerCase(Locale.ROOT));
    }

    public static Set<String> codes() {
        return CODES;
    }

    @Override
    public String toString() {
        return code;
    }
}