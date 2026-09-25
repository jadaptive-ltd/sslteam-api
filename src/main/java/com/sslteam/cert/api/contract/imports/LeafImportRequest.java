package com.sslteam.cert.api.contract.imports;

import com.sslteam.cert.api.contract.scope.PkiScope;
import java.util.UUID;

public record LeafImportRequest(
        PkiScope scope,
        UUID intermediateId,
        String certificatePem,
        String chainPem,
        Long expectedFamilyVersion,
        Long expectedIntermediateVersion) {
}
