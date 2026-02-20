package org.example.javadevops.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthResponse {
    private String applicationName;
    private long currentTimeStamp;
    private String buildVersion;
    private String message;
}