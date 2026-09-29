package com.jadaptive.sslteam.cert.api.contract.root;

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

import com.jadaptive.sslteam.cert.api.contract.family.PkiFamilyStatus;
import com.jadaptive.sslteam.cert.api.contract.scope.PkiScope;
import java.time.Instant;
import java.util.UUID;

public record RootCaSetupResponse(
        PkiScope scope,
        UUID rootId,
        PkiFamilyStatus familyStatus,
        ApplicationCaSetupState setupState,
        String rootCertificatePem,
        String intermediateCertificatePem,
        String rootPrivateKeyPem,
        String rootFingerprintSha256,
        String intermediateFingerprintSha256,
        Instant rootNotBefore,
        Instant rootNotAfter,
        Instant intermediateNotBefore,
        Instant intermediateNotAfter,
        long familyVersion,
        long rootVersion,
        long intermediateVersion,
        boolean leafIssuanceReady) {

    public RootCaSetupResponse {
        if (scope == null || rootId == null || familyStatus == null || setupState == null) {
            throw new IllegalArgumentException("scope, rootId, familyStatus, and setupState are required");
        }
        requirePem(rootCertificatePem, "rootCertificatePem");
        requirePem(intermediateCertificatePem, "intermediateCertificatePem");
        requirePem(rootPrivateKeyPem, "rootPrivateKeyPem");
        requireText(rootFingerprintSha256, "rootFingerprintSha256");
        requireText(intermediateFingerprintSha256, "intermediateFingerprintSha256");
        if (rootNotBefore == null || rootNotAfter == null
            || intermediateNotBefore == null || intermediateNotAfter == null) {
            throw new IllegalArgumentException("certificate validity is required");
        }
        if (familyVersion < 0 || rootVersion < 0 || intermediateVersion < 0) {
            throw new IllegalArgumentException("versions must be non-negative");
        }
        if (setupState == ApplicationCaSetupState.COMPLETED && !leafIssuanceReady) {
            throw new IllegalArgumentException("completed setup must enable leaf issuance");
        }
        if (setupState != ApplicationCaSetupState.COMPLETED && leafIssuanceReady) {
            throw new IllegalArgumentException("incomplete setup cannot enable leaf issuance");
        }
    }

    private static void requirePem(String value, String field) {
        requireText(value, field);
        if (!value.contains("-----BEGIN CERTIFICATE-----") && !value.contains("-----BEGIN PRIVATE KEY-----")) {
            throw new IllegalArgumentException(field + " must be PEM encoded");
        }
    }

    private static void requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " is required");
        }
    }
}
