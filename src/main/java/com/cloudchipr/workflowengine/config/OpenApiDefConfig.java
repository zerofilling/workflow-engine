package com.cloudchipr.workflowengine.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    servers = {@Server(url = "${workflow.swagger.url}", description = "Default Server URL")})
public class OpenApiDefConfig {}
