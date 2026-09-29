package com.jadaptive.sslteam.cert.api.contract.leaf;

/*-
 * #%L
 * SSLTeam API
 * %%
 * Copyright (C) 2026 Jadaptive Limited
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
