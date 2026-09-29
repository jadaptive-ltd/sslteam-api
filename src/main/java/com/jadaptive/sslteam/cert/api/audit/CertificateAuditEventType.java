package com.jadaptive.sslteam.cert.api.audit;

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

public enum CertificateAuditEventType {
    APPLICATION_CA_GENERATED,
    ROOT_KEY_EXPORT_ACKNOWLEDGED,
    APPLICATION_CA_SETUP_COMPLETED,
    APPLICATION_CA_SETUP_REJECTED,
    ROOT_CERTIFICATE_CREATED,
    ROOT_CERTIFICATE_RETIRED,
    ROOT_CERTIFICATE_REVOKED,
    CERTIFICATE_MATERIAL_DOWNLOADED,
    PRIVATE_KEY_DOWNLOADED,
    LEAF_ARTIFACT_DOWNLOADED,
    INTERMEDIATE_REQUEST_CREATED,
    INTERMEDIATE_REQUEST_EXPIRED,
    INTERMEDIATE_REQUEST_REJECTED,
    INTERMEDIATE_CERTIFICATE_IMPORTED,
    INTERMEDIATE_CERTIFICATE_RETIRED,
    INTERMEDIATE_CERTIFICATE_REVOKED,
    INTERMEDIATE_CERTIFICATE_REJECTED,
    LEAF_CERTIFICATE_ISSUED,
    LEAF_CERTIFICATE_REVOKED,
    LEAF_CERTIFICATE_REJECTED,
    LEAF_ATTENTION_UPDATED,
    KEY_CUSTODY_STORED,
    KEY_CUSTODY_READ_FAILED,
    KEY_CUSTODY_REJECTED
}
