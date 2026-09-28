package com.jadaptive.sslteam.cert.api.contract.root;

import com.jadaptive.sslteam.cert.api.contract.scope.PkiScope;

public record RootCaSetupCompletionRequest(
        PkiScope scope,
        long expectedVersion,
        boolean encryptedRootKeyExportAcknowledged) {

    public RootCaSetupCompletionRequest {
    scope = scope == null ? PkiScope.defaults() : scope;
        if (expectedVersion < 0) {
            throw new IllegalArgumentException("expectedVersion must be non-negative");
        }
    }
}