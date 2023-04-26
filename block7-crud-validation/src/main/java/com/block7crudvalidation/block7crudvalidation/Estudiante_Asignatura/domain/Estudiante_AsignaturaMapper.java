package com.block7crudvalidation.block7crudvalidation.domain.mapper;

import com.block7crudvalidation.block7crudvalidation.controller.dto.input.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.input.Estudiante_AsignaturaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.Estudiante_AsignaturaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.domain.Estudiante_Asignatura;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Estudiante_AsignaturaMapper {
    Estudiante_AsignaturaMapper mapper = Mappers.getMapper(Estudiante_AsignaturaMapper.class);
    Estudiante_AsignaturaOutputDto estudiante_AsignaturaToEstudiante_AsignaturaOutputDto(Estudiante_Asignatura estudiante_asignatura);

    Estudiante_Asignatura estudiante_AsignaturaInputDtoToEstudiante_Asignatura(Estudiante_AsignaturaInputDto estudiante_asignaturaInputDto);
}
