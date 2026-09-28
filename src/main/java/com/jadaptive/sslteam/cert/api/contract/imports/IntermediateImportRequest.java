package com.jadaptive.sslteam.cert.api.contract.imports;

import com.jadaptive.sslteam.cert.api.contract.scope.PkiScope;

public record IntermediateImportRequest(
        PkiScope scope,
        String name,
        String certificatePem,
        String chainPem,
        String privateKeyPkcs8Pem,
        Long expectedFamilyVersion,
        Long expectedIntermediateVersion) {
}
