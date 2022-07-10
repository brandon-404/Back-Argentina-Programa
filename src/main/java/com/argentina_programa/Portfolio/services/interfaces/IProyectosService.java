/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentina_programa.Portfolio.services.interfaces;

import com.argentina_programa.Portfolio.entities.Proyectos;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author bra5j
 */
@Service
public interface IProyectosService {
    List<Proyectos> findAll();
    
    Proyectos findByProyectosID(int id); 
    
    void save(Proyectos elem);
    
    void saveAll( List < Proyectos > elems);
    
    void deleteById (int id );
    
    void update (Proyectos estudio, int id);
}
