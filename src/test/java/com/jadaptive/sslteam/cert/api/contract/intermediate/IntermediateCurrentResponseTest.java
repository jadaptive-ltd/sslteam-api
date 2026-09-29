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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class IntermediateCurrentResponseTest {

    @Test
    void notConfigured_usesStableDefaults() {
        IntermediateCurrentResponse response = IntermediateCurrentResponse.notConfigured("default");

        assertEquals("default", response.environment());
        assertEquals("NOT_CONFIGURED", response.status());
        assertNull(response.intermediateId());
        assertNull(response.name());
    }

    @Test
    void notConfigured_canCarryFamilyVersionForReplacementActivation() {
        IntermediateCurrentResponse response = IntermediateCurrentResponse.notConfigured("default", 7L);

        assertEquals("NOT_CONFIGURED", response.status());
        assertEquals(7L, response.familyVersion());
        assertNull(response.version());
    }
}
