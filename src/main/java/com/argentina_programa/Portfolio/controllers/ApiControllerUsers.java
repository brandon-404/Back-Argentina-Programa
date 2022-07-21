 
package com.argentina_programa.Portfolio.controllers;

import com.argentina_programa.Portfolio.dto.users.UserRequest;
import com.argentina_programa.Portfolio.entities.Users;
import com.argentina_programa.Portfolio.services.interfaces.IUsersService;
import com.argentina_programa.Portfolio.utils.exceptions.ApiUnprocessableEntity;
import com.argentina_programa.Portfolio.utils.hash.BCrypt;
import com.argentina_programa.Portfolio.validator.UserValidatorImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.argentina_programa.Portfolio.entities.Token;


/**
 *
 * @author bra5j
 */
@RestController
@RequestMapping ("/api/users")
public class ApiControllerUsers {
    private String secret = "ArgProg";
    
    @Autowired
    private IUsersService UService;
    @Autowired
    private UserValidatorImpl userValidator;
    @PostConstruct
    protected void init (){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }
    
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> mostrarTodos(){
        return ResponseEntity.ok(this.UService.findAll());
    }
    
     @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Object> saveUser(@RequestBody UserRequest request, @RequestHeader("Authorization") String token) throws ApiUnprocessableEntity{
         boolean bandera = getAuthentication(token);
         if(bandera){   
            this.userValidator.validator(request);
            this.UService.save(request);
         }
         return ResponseEntity.ok(bandera ? Boolean.TRUE: Boolean.FALSE);
     }
     
     @DeleteMapping( value = "/{userId}/delete")
     public ResponseEntity<Object> deleteUser(@PathVariable int userId, @RequestHeader("Authorization") String token){
         boolean bandera = getAuthentication(token);
         if(bandera)
            this.UService.deleteById(userId);
         return ResponseEntity.ok(bandera ? Boolean.TRUE: Boolean.FALSE);
     }
     @PutMapping(value = "/{userId}/update")
     public ResponseEntity<Object> updateUser (@RequestBody UserRequest request, @PathVariable int userId, @RequestHeader("Authorization") String token){
        boolean bandera = getAuthentication(token);
        if(bandera)
         this.UService.update(request, userId);   
        return ResponseEntity.ok(bandera ? Boolean.TRUE: Boolean.FALSE);
    }
    @PostMapping(value = "/loggin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> Loggin (@RequestBody UserRequest request){
        Token tok = new Token ();
        tok.setAuthorization(Autenticacion(request.getPassword(), request.getUsername()));   
        return  ResponseEntity.ok(tok);
    }
   
    
    private String Autenticacion(String pass, String user){
        String tok = "No Valido";
        
         if ( user.equals("BrandonPrograma")){
             Users users = this.UService.findByUsersname(user);
             if(BCrypt.checkpw(pass, users.getPassword() )){
                  Map<String, Object> claims = new HashMap <>();
                  claims = Jwts.claims().setSubject(users.getUsername());
                  claims.put("id", users.getId());
                  Date now = new Date();
                  Date exp = new Date(now.getTime() + 360000);
                  tok = Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(exp).signWith(SignatureAlgorithm.HS256, this.secret).compact();
             }
         }
        return tok;
    }
     private boolean getAuthentication (String token){
        String user  ="";
        if (token != null){
            user = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.replace("Bearer", "")) 
                    .getBody()
                    .getSubject();
        }
        return  user.equals("BrandonPrograma");
    }
}