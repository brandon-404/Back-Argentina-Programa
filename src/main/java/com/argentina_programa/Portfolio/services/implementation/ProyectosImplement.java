/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentina_programa.Portfolio.services.implementation;

import com.argentina_programa.Portfolio.entities.Proyectos;
import com.argentina_programa.Portfolio.repository.ProyectosRepository;
import com.argentina_programa.Portfolio.services.interfaces.IProyectosService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author bra5j
 */
@Component
public class ProyectosImplement implements IProyectosService{
    
    @Autowired
    private ProyectosRepository proyectRepo;
    
    @Override
    public List<Proyectos> findAll() {
        List<Proyectos> estudios = new ArrayList <>();
        for(Proyectos i: this.proyectRepo.findAll()){
            estudios.add(i);
        }
        return estudios;
    }

    @Override
    public Proyectos findByProyectosID(int id) {
        return this.proyectRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Proyectos elem) {
        this.proyectRepo.save(elem);
    }

    @Override
    public void saveAll(List<Proyectos> elems) {
        this.proyectRepo.saveAll(elems);
    }

    @Override
    public void deleteById(int id) {
        this.proyectRepo.deleteById(id);
    }

    @Override
    public void update(Proyectos estudio, int id) {
         Proyectos estudioR = this.proyectRepo.findById(id).orElse(null);
         estudioR.setTitulo(estudio.getTitulo());
         estudioR.setTecnologias(estudio.getTecnologias());
         estudioR.setLink(estudio.getLink());
         estudioR.setLink_image(estudio.getLink_image());
         this.proyectRepo.save(estudioR);
  
    
    }
    
}
