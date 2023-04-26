package com.block7crudvalidation.block7crudvalidation.domain.mapper;

import com.block7crudvalidation.block7crudvalidation.controller.dto.input.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstudianteMapper {
    EstudianteMapper mapper = Mappers.getMapper(EstudianteMapper.class);
    EstudianteOutputDto estudianteToEstudianteOutputDto(Estudiante estudiante);

    Estudiante estudianteInputDtoToEstudiante(EstudianteInputDto estudianteInputDto);
}
