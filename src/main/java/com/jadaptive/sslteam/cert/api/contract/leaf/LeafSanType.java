package com.jadaptive.sslteam.cert.api.contract.leaf;

import java.util.Locale;

/**
 * Closed X.509 subject-alternative-name identity vocabulary for issued server leaves.
 * The type controls both validation and certificate encoding; DNS and IP identities are never
 * interchangeable. This enum performs no DNS lookup, certificate signing, or trust decision.
 */
public enum LeafSanType {
    /** Encode a validated DNS name as an X.509 {@code dNSName} SAN. */
    DNS,
    /** Encode a validated IPv4 or IPv6 literal as an X.509 {@code iPAddress} SAN. */
    IP;

    /**
     * Parses the external case-insensitive contract spelling at the request boundary.
     *
     * @param value external SAN type value
     * @return canonical SAN type
     * @throws IllegalArgumentException when the closed vocabulary is not recognized
     */
    public static LeafSanType fromCode(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("SAN type is required");
        }
        try {
            return valueOf(value.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("SAN type must be DNS or IP", exception);
        }
    }
}
