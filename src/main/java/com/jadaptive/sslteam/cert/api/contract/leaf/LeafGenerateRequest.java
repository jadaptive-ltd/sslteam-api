package com.jadaptive.sslteam.cert.api.contract.leaf;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;

public record LeafGenerateRequest(
        @NotBlank String teamCode,
        String environment,
        @NotBlank @Size(max = 256) String name,
        String commonName,
        @NotEmpty List<@Valid LeafSan> sans,
        @NotBlank String algorithm,
        @Min(1) @Max(90) int validityDays,
        @NotBlank String outputProfile,
        String keyMode,
        String csrPem,
        @Size(max = 256) String pkcs12Password) {

}
