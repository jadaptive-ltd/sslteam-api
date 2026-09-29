package com.jadaptive.sslteam.cert.api.contract.inventory;

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

import java.time.Instant;
import java.util.UUID;

public record CaCertificateInventoryItem(
        UUID certificateId,
        CaCertificateInventoryRole role,
        UUID familyId,
        UUID rootId,
        UUID intermediateId,
        String subjectDn,
        String fingerprintSha256,
        CaCertificateInventoryStatus status,
        Instant notBefore,
        Instant notAfter,
        long version) {

    public CaCertificateInventoryItem {
        if (certificateId == null || role == null || familyId == null || status == null) {
            throw new IllegalArgumentException("certificateId, role, familyId, and status are required");
        }
        if (rootId == null && role == CaCertificateInventoryRole.ROOT) {
            throw new IllegalArgumentException("rootId is required for a Root certificate");
        }
        if (intermediateId == null && role == CaCertificateInventoryRole.INTERMEDIATE) {
            throw new IllegalArgumentException("intermediateId is required for an Intermediate certificate");
        }
        requireText(subjectDn, "subjectDn");
        requireFingerprint(fingerprintSha256);
        if (version < 0) {
            throw new IllegalArgumentException("version must be non-negative");
        }
        if (notBefore != null && notAfter != null && !notAfter.isAfter(notBefore)) {
            throw new IllegalArgumentException("notAfter must be after notBefore");
        }
    }

    private static void requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " is required");
        }
    }

    private static void requireFingerprint(String value) {
        if (value == null || !value.matches("[0-9a-fA-F]{64}")) {
            throw new IllegalArgumentException("fingerprintSha256 must be a 64-character hexadecimal value");
        }
    }
}
