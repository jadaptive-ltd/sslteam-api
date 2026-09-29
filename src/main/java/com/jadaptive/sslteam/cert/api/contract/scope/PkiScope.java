package com.jadaptive.sslteam.cert.api.contract.scope;

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

import java.util.Locale;

public record PkiScope(String team, String environment) {

    public static final String DEFAULT_TEAM = "default";
    public static final String DEFAULT_ENVIRONMENT = "default";

    public PkiScope {
        team = normalize(team, "team", DEFAULT_TEAM);
        environment = normalize(environment, "environment", DEFAULT_ENVIRONMENT);
    }

    public static PkiScope defaults() {
        return new PkiScope(DEFAULT_TEAM, DEFAULT_ENVIRONMENT);
    }

    private static String normalize(String value, String field, String defaultValue) {
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        if (normalized.contains("..")
                || !normalized.matches("[a-z0-9][a-z0-9._-]{0,62}[a-z0-9]")) {
            throw new IllegalArgumentException(field + " must match [a-z0-9][a-z0-9._-]{0,62}[a-z0-9]");
        }
        return normalized;
    }
}
