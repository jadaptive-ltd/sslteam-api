package com.jadaptive.sslteam.cert.api.contract.family;

/**
 * Lifecycle status of one team/environment PKI family.
 *
 * <p>The status describes the family lifecycle only. It is not an authorization
 * decision and must not replace certificate-chain verification, custody checks,
 * permission checks, or optimistic-lock validation. In particular, a family is
 * publishable as ready only after its persisted root/intermediate relationships
 * and cryptographic readiness checks succeed.</p>
 */
public enum PkiFamilyStatus {
    /**
     * No usable PKI family exists for the requested scope. This is the safe
     * initial state and prevents issuance from proceeding implicitly.
     */
    NOT_CONFIGURED,

    /**
     * Family creation or a controlled replacement is in progress. Mutations
     * must be coordinated, and certificate issuance remains unavailable until
     * readiness checks complete successfully.
     */
    PROVISIONING,

    /**
     * The family has a validated authoritative root and an operational
     * issuing path. This is the only status that may make normal leaf issuance
     * available, subject to authorization, validity, and policy checks.
     */
    READY,

    /**
     * The family still exists, but an expected operational component is
     * unavailable or no longer satisfies readiness requirements. It preserves
     * inventory and recovery visibility while preventing unsafe new issuance.
     */
    DEGRADED,

    /**
     * Provisioning or a lifecycle operation failed. The failure must remain
     * diagnosable through activity evidence and safe reason codes; recovery
     * requires an explicit controlled operation rather than silent regeneration.
     */
    FAILED,

    /**
     * The family is permanently retired for new operations. Historical
     * certificates and append-only activity remain queryable according to
     * authorization and retention policy, but the family cannot issue new
     * certificates or be silently reactivated.
     */
    RETIRED
}
