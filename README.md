# SSLTeam API

`sslteam-api` is the public, framework-neutral Java contract library for SSLTeam APIs.

It contains the shared request and response records, enums, validation annotations, certificate inventory models, and audit models used by SSLTeam server adapters, the reusable Java client, and the CLI.

## Scope

This artifact owns the wire contract only. It does not contain certificate signing, issuance policy, persistence, REST runtime code, TLS transport, or authentication implementation.

The existing `com.jadaptive.sslteam.cert.api` package names are preserved so server and client consumers can share the same models without duplicate definitions or source-level API changes.

## Maven

```xml
<dependency>
  <groupId>com.jadaptive</groupId>
  <artifactId>sslteam-api</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Build

```sh
mvn test
```

The project targets Java 25.