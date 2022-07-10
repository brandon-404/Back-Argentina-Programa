/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentina_programa.Portfolio.controllers;

import com.argentina_programa.Portfolio.entities.Social;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.argentina_programa.Portfolio.services.interfaces.ISocialService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author bra5j
 */
@RestController
@RequestMapping("api/social")
public class ApiControllerSocial {
    
    @Autowired 
    private ISocialService socialS;
    
      
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> mostrarTodos(){
        return ResponseEntity.ok(this.socialS.findAll());
    }
    @GetMapping (value = "/by/{id}")
    public ResponseEntity <Object> findById(@PathVariable int id){
        return ResponseEntity.ok(this.socialS.findBySocialID(id));
    }
    @GetMapping(value = "/by/social_name/{red_social}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByUsername (@PathVariable("red_social") String red_social){
        return ResponseEntity.ok(this.socialS.findByRedSocial(red_social));
    }
    @PostMapping ( value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> save (@RequestBody Social estudio){
        this.socialS.save(estudio);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    @DeleteMapping ( value = "/{id}/delete")
    public ResponseEntity <Object> delete ( @PathVariable int id){
        this.socialS.deleteById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    @PostMapping (value = "/{id}/update")
    public ResponseEntity <Object> update ( @RequestBody Social estudio,@PathVariable int id){
        this.socialS.update(estudio, id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}