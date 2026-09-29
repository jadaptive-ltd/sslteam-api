package com.jadaptive.sslteam.cert.api.contract.intermediate;

/*-
 * #%L
 * SSLTeam API
 * %%
 * Copyright (C) 2026 Jadaptive Limited
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.jadaptive.sslteam.cert.api.contract.leaf.LeafSummary;
import java.util.List;

public record IntermediateHistoryItem(
        String intermediateId,
        String name,
        String status,
        String subjectDn,
        String fingerprintSha256,
        String notBeforeUtc,
        String activatedAtUtc,
        String notAfterUtc,
        String revokedAtUtc,
        String revokeReason,
        String retiredAtUtc,
        String retireReason,
        long version,
        List<LeafSummary> signedLeafCertificates) {

    public IntermediateHistoryItem {
        signedLeafCertificates = signedLeafCertificates == null ? List.of() : List.copyOf(signedLeafCertificates);
    }
}
