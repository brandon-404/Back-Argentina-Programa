
package com.argentina_programa.Portfolio.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *@NOT_FOUND personnalizada error N° 404
 * 
 * @author bra5j
 */ 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFound extends Exception{
    public  ApiNotFound ( String message){
        super(message);
    }
}
