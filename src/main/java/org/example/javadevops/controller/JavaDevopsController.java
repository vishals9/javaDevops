package org.example.javadevops.controller;

import org.example.javadevops.response.HealthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaDevopsController {

    @Value("${spring.application.name:javaDevops}")
    private String applicationName;

    @Value("${message:Java DevOps Example}")
    private String message;

    @GetMapping("/health/details")
    public HealthResponse healthDetails() {
        HealthResponse healthResponse = new HealthResponse();
        // get application name from properties
        healthResponse.setApplicationName(applicationName);
        healthResponse.setCurrentTimeStamp(System.currentTimeMillis());
        // use System.getenv to get the value of BUILD_VERSION environment variable
        String buildVersion = System.getenv().getOrDefault("BUILD_VERSION", "1.0.0");
        healthResponse.setBuildVersion(buildVersion);
        // get custom message from properties
        healthResponse.setMessage(message);
        return healthResponse;
    }
}
