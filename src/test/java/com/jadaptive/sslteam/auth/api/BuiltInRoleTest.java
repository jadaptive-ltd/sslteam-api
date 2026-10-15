package com.jadaptive.sslteam.auth.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BuiltInRoleTest {

    @Test
    void parsesCanonicalCodesWithoutChangingWireValues() {
        assertEquals(BuiltInRole.ADMIN, BuiltInRole.fromCode(" ROLE_ADMIN "));
        assertEquals("role_operator", BuiltInRole.OPERATOR.code());
        assertEquals("role_viewer", BuiltInRole.VIEWER.toString());
        assertEquals("Administrator", BuiltInRole.ADMIN.displayName());
    }

    @Test
    void safelyChecksAndRejectsUnknownCodes() {
        assertTrue(BuiltInRole.isBuiltInCode("role_admin"));
        assertFalse(BuiltInRole.isBuiltInCode("role_owner"));
        assertThrows(IllegalArgumentException.class, () -> BuiltInRole.fromCode("role_owner"));
        assertThrows(IllegalArgumentException.class, () -> BuiltInRole.fromCode(" "));
    }
}