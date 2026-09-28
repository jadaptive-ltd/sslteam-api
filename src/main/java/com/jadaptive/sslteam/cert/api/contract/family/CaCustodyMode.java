package com.jadaptive.sslteam.cert.api.contract.family;

import java.util.Locale;

public enum CaCustodyMode {
    SERVER,
    OFFLINE_CLI;

    public static CaCustodyMode parse(String value) {
        if (value == null || value.isBlank()) {
            return SERVER;
        }
        try {
            return valueOf(value.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("custodyMode must be SERVER or OFFLINE_CLI", exception);
        }
    }
}
