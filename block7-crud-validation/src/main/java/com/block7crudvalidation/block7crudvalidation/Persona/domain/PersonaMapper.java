package com.block7crudvalidation.block7crudvalidation.domain.mapper;

import com.block7crudvalidation.block7crudvalidation.controller.dto.input.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);
    PersonaOutputDto personaToPersonOutputDto(Persona persona);

    Persona personaInputDtoToPersona(PersonaInputDto personaInputDto);

}
