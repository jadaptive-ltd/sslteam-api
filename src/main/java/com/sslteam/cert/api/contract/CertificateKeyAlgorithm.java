package com.sslteam.cert.api.contract;

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
