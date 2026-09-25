package com.sslteam.cert.api.contract.leaf;

import java.util.List;

public record LeafListResponse(
        String teamCode,
        String environment,
        List<LeafSummary> items) {
}
