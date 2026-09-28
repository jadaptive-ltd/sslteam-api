package com.jadaptive.sslteam.cert.api.contract.intermediate;

import java.util.ArrayList;
import java.util.List;

public record IntermediatePendingRequestsResponse(
        List<IntermediatePendingRequestSummary> items) {

    public IntermediatePendingRequestsResponse {
        items = items == null ? new ArrayList<>() : new ArrayList<>(items);
    }
}
