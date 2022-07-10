
package com.argentina_programa.Portfolio.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @UNPROCESSABLE_ENTITY personnalizada error N° 422
 *
 * @author bra5j
 */
 @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception{
    public ApiUnprocessableEntity (String message){
        super(message);
    }
}
