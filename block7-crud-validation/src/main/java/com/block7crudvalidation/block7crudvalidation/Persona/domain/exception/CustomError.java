package com.block7crudvalidation.block7crudvalidation.domain.exception;

import com.block7crudvalidation.block7crudvalidation.controller.dto.output.CustomErrorOutputDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CustomError extends Exception{
    Date datetime = new Date();
    int httpCode;
    String mensaje;

    public CustomErrorOutputDto customErrorToCustomErrorOutputDto(){
        return new CustomErrorOutputDto(this.datetime,this.httpCode,this.mensaje);
    }
}