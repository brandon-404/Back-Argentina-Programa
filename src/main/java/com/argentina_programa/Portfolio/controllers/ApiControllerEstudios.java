/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentina_programa.Portfolio.controllers;

import com.argentina_programa.Portfolio.entities.Estudios;
import com.argentina_programa.Portfolio.services.interfaces.IEstudiosService;
import io.jsonwebtoken.Jwts;
import java.util.Base64;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.*;
import com.argentina_programa.Portfolio.utils.exceptions.ApiUnauthorizazed;

/**
 *
 * @author bra5j
 */
@RestController
@RequestMapping ("/api/estudios")
public class ApiControllerEstudios {
    private String secret = "ArgProg";
    @Autowired
    private IEstudiosService EstuServ;
    
     @PostConstruct
    protected void init (){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }
    
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> mostrarTodos(){
        return ResponseEntity.ok(this.EstuServ.findAll());
    }
    @GetMapping (value = "/by/{id}")
    public ResponseEntity <Object> findById(@PathVariable int id){
        return ResponseEntity.ok(this.EstuServ.findByEstudiosID(id));
    }
    @PostMapping ( value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> save (@RequestBody Estudios estudio, @RequestHeader("Authorization") String token)throws ApiUnauthorizazed{
        try{ 
        boolean bandera = getAuthentication(token);
        if(bandera)
            this.EstuServ.save(estudio);
        return ResponseEntity.ok(bandera ? Boolean.TRUE: Boolean.FALSE);
         }catch( MalformedJwtException e ){
            throw new ApiUnauthorizazed("JWT mal formado");
        }catch (UnsupportedJwtException e){
            throw new ApiUnauthorizazed ("token no soportado");
        }catch (ExpiredJwtException e){
            throw new ApiUnauthorizazed("token expirado");
        }catch (IllegalArgumentException e){
            throw new ApiUnauthorizazed ("token vacío");
        }catch (SignatureException e){
            throw new ApiUnauthorizazed ("fail en la firma");
        }
    }
    @DeleteMapping ( value = "/{id}/delete")
    public ResponseEntity <Object> delete ( @PathVariable int id, @RequestHeader("Authorization") String token)throws ApiUnauthorizazed{
        try{ 
        boolean bandera = getAuthentication(token);
        if(bandera)
            this.EstuServ.deleteById(id);
        return ResponseEntity.ok(bandera ? Boolean.TRUE: Boolean.FALSE);
         }catch( MalformedJwtException e ){
            throw new ApiUnauthorizazed("JWT mal formado");
        }catch (UnsupportedJwtException e){
            throw new ApiUnauthorizazed ("token no soportado");
        }catch (ExpiredJwtException e){
            throw new ApiUnauthorizazed("token expirado");
        }catch (IllegalArgumentException e){
            throw new ApiUnauthorizazed ("token vacío");
        }catch (SignatureException e){
            throw new ApiUnauthorizazed ("fail en la firma");
        }
    }
    @PostMapping (value = "/{id}/update")
    public ResponseEntity <Object> update ( @RequestBody Estudios estudio,@PathVariable int id,@RequestHeader("Authorization") String token)throws ApiUnauthorizazed{
        try{ 
        boolean bandera = getAuthentication(token);
        if(bandera)
            this.EstuServ.update(estudio, id);
        return ResponseEntity.ok(bandera ? Boolean.TRUE: Boolean.FALSE);
         }catch( MalformedJwtException e ){
            throw new ApiUnauthorizazed("JWT mal formado");
        }catch (UnsupportedJwtException e){
            throw new ApiUnauthorizazed ("token no soportado");
        }catch (ExpiredJwtException e){
            throw new ApiUnauthorizazed("token expirado");
        }catch (IllegalArgumentException e){
            throw new ApiUnauthorizazed ("token vacío");
        }catch (SignatureException e){
            throw new ApiUnauthorizazed ("fail en la firma");
        }
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
