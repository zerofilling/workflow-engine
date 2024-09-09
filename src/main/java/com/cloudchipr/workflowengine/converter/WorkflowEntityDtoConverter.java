package com.cloudchipr.workflowengine.converter;

import com.cloudchipr.workflowengine.config.ConversionServiceAdapter;
import com.cloudchipr.workflowengine.dto.WorkflowDto;
import com.cloudchipr.workflowengine.entity.WorkflowEntity;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = ConversionServiceAdapter.class)
public interface WorkflowEntityDtoConverter
    extends Converter<WorkflowEntity, WorkflowDto> {

  @Override
  WorkflowDto convert(WorkflowEntity source);
}
