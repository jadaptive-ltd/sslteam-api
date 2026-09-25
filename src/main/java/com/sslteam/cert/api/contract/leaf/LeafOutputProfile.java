package com.sslteam.cert.api.contract.leaf;

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
