package com.block7crudvalidation.block7crudvalidation.domain.mapper;

import com.block7crudvalidation.block7crudvalidation.controller.dto.input.ProfesorInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.ProfesorOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfesorMapper {
    ProfesorMapper mapper = Mappers.getMapper(ProfesorMapper.class);
    ProfesorOutputDto profesorToProfesorOutputDto(Profesor profesor);

    Profesor profesorInputDtoToProfesor(ProfesorInputDto profesorInputDto);
}
