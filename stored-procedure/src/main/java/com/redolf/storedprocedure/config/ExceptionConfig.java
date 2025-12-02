package com.redolf.storedprocedure.config;

import com.redolf.storedprocedure.dtos.exception.ConversionException;
import com.redolf.storedprocedure.exceptions.ConversionHandlerException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionConfig {

    @Bean
    @ExceptionHandler(ConverterNotFoundException.class)
    public ResponseEntity<ConversionException> conversionHandlerException(){
        return new ResponseEntity<>(new ConversionException("Error occurred while converting the record", HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now()),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<ConversionException> storedProcedureNotFound(){
        return new ResponseEntity<>(new ConversionException("Stored procedure does not exist", HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
