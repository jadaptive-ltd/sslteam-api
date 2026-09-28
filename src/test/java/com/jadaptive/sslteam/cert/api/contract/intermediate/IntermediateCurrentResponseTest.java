package com.jadaptive.sslteam.cert.api.contract.intermediate;

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
