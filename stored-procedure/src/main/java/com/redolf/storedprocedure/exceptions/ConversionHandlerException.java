package com.redolf.storedprocedure.exceptions;

import org.springframework.stereotype.Component;


public class ConversionHandlerException extends Exception {
    public ConversionHandlerException(String message) {
        super(message);
    }
}
