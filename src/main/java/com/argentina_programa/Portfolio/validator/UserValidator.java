
package com.argentina_programa.Portfolio.validator;

import com.argentina_programa.Portfolio.dto.users.UserRequest;
import com.argentina_programa.Portfolio.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

/**
 * inteface para la validacion de datos recividos
 * para la creacion de usuarios
 * 
 * @author bra5j
 */
@Service
public interface UserValidator {
    void validator (UserRequest request) throws  ApiUnprocessableEntity;
}
