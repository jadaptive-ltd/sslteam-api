package com.jadaptive.sslteam.cert.api.contract;

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

public enum CertificateKeyAlgorithm {
    ECDSA_P256("ecdsa-p256"),
    ECDSA_P384("ecdsa-p384"),
    RSA_3072("rsa-3072"),
    RSA_4096("rsa-4096");

    private final String code;

    CertificateKeyAlgorithm(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }

    public static CertificateKeyAlgorithm fromCode(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("key algorithm is required");
        }
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        for (CertificateKeyAlgorithm algorithm : values()) {
            if (algorithm.code.equals(normalized)) {
                return algorithm;
            }
        }
        throw new IllegalArgumentException("Unsupported certificate key algorithm: " + value);
    }
}
