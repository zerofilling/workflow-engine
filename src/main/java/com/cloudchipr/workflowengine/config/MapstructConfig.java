package com.cloudchipr.workflowengine.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.extensions.spring.SpringMapperConfig;

@MapperConfig(componentModel = "spring", uses = ConversionServiceAdapter.class)
@SpringMapperConfig(conversionServiceAdapterPackage = "com.cloudchipr.workflowengine.config")
public class MapstructConfig {}
