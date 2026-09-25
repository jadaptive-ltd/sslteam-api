package com.sslteam.cert.api.contract.intermediate;

import java.util.List;

public record IntermediateHistoryResponse(
        String teamCode,
        String environment,
        List<IntermediateHistoryItem> items) {

    public IntermediateHistoryResponse {
        items = items == null ? List.of() : List.copyOf(items);
    }
}
