package com.block7crudvalidation.block7crudvalidation.exception.domain;

import com.block7crudvalidation.block7crudvalidation.exception.controller.dto.CustomErrorOutputDto;
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
