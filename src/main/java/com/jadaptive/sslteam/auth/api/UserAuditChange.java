package com.jadaptive.sslteam.auth.api;

import java.util.Objects;

public record UserAuditChange(
        String field,
        String oldValue,
        String newValue,
        boolean redacted) {

    public UserAuditChange {
        field = Objects.requireNonNull(field, "field is required");
        oldValue = oldValue == null ? "<null>" : oldValue;
        newValue = newValue == null ? "<null>" : newValue;
    }
}