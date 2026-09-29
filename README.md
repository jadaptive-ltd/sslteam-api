# SSLTeam API

Framework-neutral Java contracts for the SSLTeam certificate and authentication APIs.

`sslteam-api` is the shared contract layer used by SSLTeam services, the Java client, and the
command-line application. It gives producers and consumers the same typed representation of
requests, responses, certificate state, scopes, inventories, and audit data.

**Current version:** `1.0.0-SNAPSHOT`<br>
**Java:** 25

## Why this project exists

SSLTeam integrations should not need to depend on server internals or duplicate the API model in
every application. This library keeps the public wire contract in one small, framework-independent
artifact that can be shared across services, clients, and tooling.

It is intentionally a contract library, not a complete SSLTeam SDK. It does not make HTTP calls,
choose TLS trust, persist credentials, sign certificates, enforce authorization, or provide REST
resources.

## What's included

- Root, intermediate, and leaf certificate request and response models
- Certificate lifecycle, family, inventory, and audit contracts
- Certificate import and artifact-download contracts
- Team and environment scope models
- Authentication, refresh, device authorization, and JWT discovery responses
- Certificate algorithm and status enums
- Jakarta Validation annotations used by contract fields

The public Java namespace is `com.jadaptive.sslteam.cert.api`, organized by domain:
`root`, `intermediate`, `leaf`, `inventory`, `imports`, `family`, and `scope`.

## How SSLTeam uses it

Inside `sslteam-services`, this artifact is consumed by the certificate core and REST modules, the
reusable `sslteam-client`, and the CLI. The client serializes and deserializes these same records;
the service modules remain responsible for authorization, policy, persistence, and lifecycle
decisions.

This makes the API artifact useful for:

- Java services integrating with SSLTeam endpoints
- adapters that translate SSLTeam contracts into another framework
- test fixtures and contract tests
- applications that need typed API models without the server runtime

## Maven coordinates

```xml
<dependency>
  <groupId>com.jadaptive</groupId>
  <artifactId>sslteam-api</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

The current version is a development snapshot. Snapshot consumers should use the repository that
hosts the snapshot before resolving this dependency:

```xml
<repository>
  <id>central-jadaptive</id>
  <url>https://central.sonatype.com/repository/maven-snapshots/</url>
  <releases><enabled>false</enabled></releases>
  <snapshots><enabled>true</enabled></snapshots>
</repository>
```

## Minimal contract flow

`PkiScope` keeps the team and environment together when a certificate operation is scoped. The
contract library validates these values and carries them through request and response types; it
does not send HTTP requests itself:

```java
import com.jadaptive.sslteam.cert.api.contract.root.RootCaSetupRequest;
import com.jadaptive.sslteam.cert.api.contract.scope.PkiScope;

PkiScope scope = new PkiScope("default", "default");
RootCaSetupRequest request = new RootCaSetupRequest(
  scope, "sslteam-root", "Example Organization", "Security");
```

The embedding application can serialize this request and send it through its chosen service client
or adapter.

For the typed HTTP client, pair this artifact with
[`sslteam-client`](https://github.com/jadaptive-ltd/sslteam-client).

## Related projects

- [`sslteam-client`](https://github.com/jadaptive-ltd/sslteam-client): typed Java client for calling SSLTeam services
- [SSLTeam organization](https://github.com/jadaptive-ltd): project source and issue tracking

## License

Copyright (C) 2026 Jadaptive Limited.

This project is licensed under the Apache License, Version 2.0. See the
[Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) for details.