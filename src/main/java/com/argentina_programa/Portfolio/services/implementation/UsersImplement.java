
package com.argentina_programa.Portfolio.services.implementation;

import com.argentina_programa.Portfolio.dto.users.UserRequest;
import com.argentina_programa.Portfolio.dto.users.UsersDTO;
import com.argentina_programa.Portfolio.entities.Users;
import com.argentina_programa.Portfolio.repository.UsersRepository;
import com.argentina_programa.Portfolio.services.interfaces.IUsersService;
import com.argentina_programa.Portfolio.utils.helper.Helpers;
import com.argentina_programa.Portfolio.utils.hash.BCrypt;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author bra5j
 */
@Component
public class UsersImplement implements IUsersService{
     
    @Autowired
    private UsersRepository usersRepo;
    
    @Override 
    public List<UsersDTO> findAll() {
        List<UsersDTO> usersDTO = new ArrayList<>();
        Iterable<Users> users = this.usersRepo.findAll();
        
        for (Users i: users){
            UsersDTO userDTO = Helpers.modelMapper().map(i, UsersDTO.class);
            usersDTO.add(userDTO);
        }
        return usersDTO; 
    }
    @Override
    public UsersDTO findByUsersname(String username) {
        Users users = this.usersRepo.findByUsername(username).orElse(null);
        return users == null ? null : Helpers.modelMapper().map(users, UsersDTO.class);
    }

    @Override
    public UsersDTO findByUserID(int userId) {
        Users users = this.usersRepo.findById(userId).orElse(null);
        return users == null ? null : Helpers.modelMapper().map(users, UsersDTO.class);
    }

    @Override
    public void save(UserRequest userR) {
        Users user = Helpers.modelMapper().map(userR, Users.class);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        this.usersRepo.save(user);
    }
    @Override
    public void update(UserRequest userR, int id) {
        Users user = this.usersRepo.findById(id).orElse(null);
        if(user != null){
             if(!userR.getName().isEmpty()){
                user.setName(userR.getName());
             }
            if(!userR.getUsername().isEmpty()){
              user.setUsername(userR.getUsername());
            }
            if(!userR.getPassword().isEmpty()){
              user.setPassword(BCrypt.hashpw(userR.getPassword(), BCrypt.gensalt()));  
            }
             if(!userR.getCorreo().isEmpty()){
              user.setCorreo(userR.getCorreo());
            }
              if(!userR.getTitulo().isEmpty()){
              user.setTitulo(userR.getTitulo());
            }
               if(!userR.getImg_perfil().isEmpty()){
              user.setImg_perfil(userR.getImg_perfil());
            }
                if(!userR.getImg_portada().isEmpty()){
              user.setImg_portada(userR.getImg_portada());
            }
            
            this.usersRepo.save(user);
        }
        
    }

    @Override
    public void saveAll(List<UserRequest> usersR) {
        List<Users> users = new ArrayList<>();
        
        for (UserRequest i : usersR){
            Users t = Helpers.modelMapper().map(i, Users.class);
            users.add(t);
        }
        
        this.usersRepo.saveAll(users);
    }

    @Override
    public void deleteById(int userId) {
        this.usersRepo.deleteById(userId);
    }

}
