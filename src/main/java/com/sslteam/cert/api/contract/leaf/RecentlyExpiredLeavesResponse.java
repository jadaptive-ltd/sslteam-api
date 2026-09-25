package com.sslteam.cert.api.contract.leaf;

import java.util.List;

public record RecentlyExpiredLeavesResponse(
        String teamCode,
        String environment,
        List<RecentlyExpiredLeafResponse> items) {
}