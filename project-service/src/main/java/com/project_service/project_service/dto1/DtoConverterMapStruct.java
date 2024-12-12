package com.project_service.project_service.dto1;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DtoConverterMapStruct {

    DtoConverterMapStruct MAPPER = Mappers.getMapper(DtoConverterMapStruct.class);

}
