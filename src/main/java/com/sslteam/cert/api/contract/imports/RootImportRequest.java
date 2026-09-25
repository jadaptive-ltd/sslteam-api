package com.sslteam.cert.api.contract.imports;

import com.sslteam.cert.api.contract.scope.PkiScope;

public record RootImportRequest(
        PkiScope scope,
        String certificatePem,
        String privateKeyPkcs8Pem,
        Long expectedFamilyVersion) {
}
