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

/**
 * Closed vocabulary for the sensitive material delivered in a leaf issuance ZIP.
 * BOTH and PKCS12_ONLY require a password-protected PKCS#12 file; PEM_ONLY deliberately
 * delivers an unencrypted PEM private key for runtimes that cannot consume PKCS#12.
 */
public enum LeafOutputProfile {
    BOTH,
    PKCS12_ONLY,
    PEM_ONLY;

    public boolean includesPkcs12() {
        return this == BOTH || this == PKCS12_ONLY;
    }

    public boolean includesPemPrivateKey() {
        return this == BOTH || this == PEM_ONLY;
    }
}
