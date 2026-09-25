package com.sslteam.cert.api.contract;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sslteam.cert.api.contract.family.CaCustodyMode;
import com.sslteam.cert.api.contract.family.PkiFamilyStatus;
import com.sslteam.cert.api.contract.root.RootCaSetupCompletionRequest;
import com.sslteam.cert.api.contract.root.RootCaSetupRequest;
import com.sslteam.cert.api.contract.root.RootCertificateResponse;
import com.sslteam.cert.api.contract.root.RootRetireRequest;
import com.sslteam.cert.api.contract.root.RootRevokeRequest;
import com.sslteam.cert.api.contract.scope.PkiScope;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class PkiContractTest {

    @Test
    void scope_normalizesValuesAndProvidesSafeDefaults() {
        PkiScope scope = new PkiScope(" TEAM_A ", " Default ");

        assertEquals("team_a", scope.team());
        assertEquals("default", scope.environment());
        assertEquals(new PkiScope("default", "default"), PkiScope.defaults());
    }

    @Test
    void scope_rejectsMalformedOrAmbiguousValues() {
        assertThrows(IllegalArgumentException.class, () -> new PkiScope("team/one", "default"));
        assertThrows(IllegalArgumentException.class, () -> new PkiScope("team", "default..test"));
        assertThrows(IllegalArgumentException.class, () -> new PkiScope("-team", "default"));
    }

    @Test
    void rootRequests_defaultMissingScopeToTheCanonicalDevelopmentScope() {
        assertEquals(PkiScope.defaults(), new RootCaSetupRequest(null, "Root", "Org", "Unit").scope());
        assertEquals(PkiScope.defaults(), new RootCaSetupCompletionRequest(null, 0, true).scope());
        assertEquals(PkiScope.defaults(), new RootRetireRequest(null, 0L, 0L, "retire").scope());
        assertEquals(PkiScope.defaults(), new RootRevokeRequest(null, 0L, 0L, "revoke").scope());
    }

    @Test
    void custodyMode_defaultsToServerAndRejectsUnknownValues() {
        assertEquals(CaCustodyMode.SERVER, CaCustodyMode.parse(null));
        assertEquals(CaCustodyMode.OFFLINE_CLI, CaCustodyMode.parse("offline_cli"));
        assertThrows(IllegalArgumentException.class, () -> CaCustodyMode.parse("browser"));
    }

    @Test
    void rootResponse_containsPublicMaterialAndDeliveryStateOnly() {
        RootCertificateResponse response = new RootCertificateResponse(
                PkiScope.defaults(),
                UUID.randomUUID(),
                "CN=Root",
                "abc123",
                PkiFamilyStatus.READY,
                CaCustodyMode.SERVER,
                "-----BEGIN CERTIFICATE-----\npublic\n-----END CERTIFICATE-----",
                "abc123",
                Instant.parse("2026-01-01T00:00:00Z"),
                Instant.parse("2027-01-01T00:00:00Z"),
                4,
                7,
                true,
                null,
                null,
                null,
                null);

        assertEquals(PkiFamilyStatus.READY, response.familyStatus());
        assertEquals("abc123", response.fingerprintSha256());
        assertEquals(4, response.version());
    }
}
