
package com.argentina_programa.Portfolio.services.interfaces;


import com.argentina_programa.Portfolio.dto.users.UserRequest;
import com.argentina_programa.Portfolio.dto.users.UsersDTO;
import com.argentina_programa.Portfolio.entities.Users;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author bra5j
 */
@Service
public interface IUsersService {
    List<UsersDTO> findAll();
    
    Users findByUsersname(String username);
    
    UsersDTO findByUserID(int userId);   
    
    void save(UserRequest user);
    
    void saveAll( List < UserRequest > users);
    
    void deleteById (int userId );
    
    void update (UserRequest user, int id);
}