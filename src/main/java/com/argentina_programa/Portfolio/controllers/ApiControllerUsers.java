 
package com.argentina_programa.Portfolio.controllers;

import com.argentina_programa.Portfolio.dto.users.UserRequest;
import com.argentina_programa.Portfolio.services.interfaces.IUsersService;
import com.argentina_programa.Portfolio.utils.exceptions.ApiUnprocessableEntity;
import com.argentina_programa.Portfolio.validator.UserValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bra5j
 */
@RestController
@RequestMapping ("/api/users")
public class ApiControllerUsers {
    
    @Autowired
    private IUsersService UService;
    @Autowired
    private UserValidatorImpl userValidator;
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> mostrarTodos(){
        return ResponseEntity.ok(this.UService.findAll());
    }
    @GetMapping(value = "/by/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByUsername (@PathVariable("username") String username){
        return ResponseEntity.ok(this.UService.findByUsersname(username));
    }
    
     @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Object> saveUser(@RequestBody UserRequest request) throws ApiUnprocessableEntity{
         this.userValidator.validator(request);
         this.UService.save(request);
         return ResponseEntity.ok(Boolean.TRUE);
     }
     
     @DeleteMapping( value = "/{userId}/delete")
     public ResponseEntity<Object> deleteUser(@PathVariable int userId){
         this.UService.deleteById(userId);
         return ResponseEntity.ok(Boolean.TRUE);
     }
     @PutMapping(value = "/{userId}/update")
     public ResponseEntity<Object> updateUser (@RequestBody UserRequest request, @PathVariable int userId){
         this.UService.update(request, userId);   
        return ResponseEntity.ok(Boolean.TRUE );
    }
} 
