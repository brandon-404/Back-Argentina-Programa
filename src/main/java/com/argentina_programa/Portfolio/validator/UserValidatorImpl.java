
package com.argentina_programa.Portfolio.validator;

import com.argentina_programa.Portfolio.dto.users.UserRequest;
import com.argentina_programa.Portfolio.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;


@Component
public class UserValidatorImpl implements UserValidator{

    @Override
    public void validator(UserRequest request) throws ApiUnprocessableEntity {
        if(request.getName()== null || request.getName().isEmpty()){
            message("El nombre es obligatorio");
        }
        if(request.getUsername()== null || request.getUsername().isEmpty()){
            message("El nombre de usuario es obligatorio");
        }
         if(request.getPassword()== null || request.getPassword().isEmpty()){
            message("la contraseña de usuario es obligatorio");
        }
        if(request.getPassword().length() < 8){
            message("la contraseña debe tener como minimo 8 caracteres");
        }

    }
    private void message(String messa)throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(messa);
    }
}
