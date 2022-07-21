/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentina_programa.Portfolio.controllers;

import com.argentina_programa.Portfolio.entities.Skills;
import com.argentina_programa.Portfolio.services.interfaces.ISkillsService;
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

/**
 *
 * @author bra5j
 */
@RestController
@RequestMapping ("/api/skills")
public class ApiControllerSkills {
    private String secret = "ArgProg";
    @Autowired
    private ISkillsService SkillServ;
    @PostConstruct
    protected void init (){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> mostrarTodos(){
        return ResponseEntity.ok(this.SkillServ.findAll());
    }
    
    @GetMapping (value = "/by/{id}")
    public ResponseEntity <Object> findById(@PathVariable int id){
        return ResponseEntity.ok(this.SkillServ.findBySkillsID(id));
    }
    @PostMapping ( value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> save (@RequestBody Skills estudio, @RequestHeader("Authorization") String token){
        boolean bandera = getAuthentication(token);
        if(bandera)
            this.SkillServ.save(estudio);
        return ResponseEntity.ok(bandera ? Boolean.TRUE: Boolean.FALSE);
    }
    @DeleteMapping ( value = "/{id}/delete")
    public ResponseEntity <Object> delete ( @PathVariable int id, @RequestHeader("Authorization") String token){
        boolean bandera = getAuthentication(token);
        if(bandera)
            this.SkillServ.deleteById(id);
        return ResponseEntity.ok(bandera ? Boolean.TRUE: Boolean.FALSE);
    }
    @PostMapping (value = "/{id}/update")
    public ResponseEntity <Object> update ( @RequestBody Skills exp,@PathVariable int id,@RequestHeader("Authorization") String token){
        boolean bandera = getAuthentication(token);
        if(bandera)
            this.SkillServ.update(exp, id);
        return ResponseEntity.ok(bandera ? Boolean.TRUE: Boolean.FALSE);
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
