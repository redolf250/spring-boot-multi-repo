package com.redolf.storedprocedure.dtos.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversionException {
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;
}
