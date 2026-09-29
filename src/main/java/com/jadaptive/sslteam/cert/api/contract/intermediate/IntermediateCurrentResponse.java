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

import jakarta.validation.constraints.NotBlank;

public record IntermediateCurrentResponse(
        @NotBlank String environment,
        @NotBlank String status,
        String intermediateId,
        String name,
        String subjectDn,
        String fingerprintSha256,
        String serialNumber,
        String notBeforeUtc,
        String activatedAtUtc,
        String notAfterUtc,
        Long version,
        Long familyVersion) {

    public static IntermediateCurrentResponse notConfigured(String environment) {
        return notConfigured(environment, null);
    }

    public static IntermediateCurrentResponse notConfigured(String environment, Long familyVersion) {
        return new IntermediateCurrentResponse(
            environment, "NOT_CONFIGURED", null, null, null, null, null, null, null, null, null, familyVersion);
    }
}
