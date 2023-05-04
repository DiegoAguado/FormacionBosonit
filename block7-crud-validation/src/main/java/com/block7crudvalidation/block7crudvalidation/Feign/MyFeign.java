package com.block7crudvalidation.block7crudvalidation.Feign;

import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@FeignClient(url = "http://localhost:8080", name = "feignProfesor")
public interface MyFeign {
    @RequestLine("GET")
    String getProfesor() throws EntityNotFoundException;
}
