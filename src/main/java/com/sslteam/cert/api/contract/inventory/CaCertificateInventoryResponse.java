package com.sslteam.cert.api.contract.inventory;

import com.sslteam.cert.api.contract.scope.PkiScope;
import java.util.List;

public record CaCertificateInventoryResponse(
        PkiScope scope,
        List<CaCertificateInventoryItem> items) {

    public CaCertificateInventoryResponse {
        if (scope == null || items == null) {
            throw new IllegalArgumentException("scope and items are required");
        }
        items = List.copyOf(items);
    }
}