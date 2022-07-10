/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentina_programa.Portfolio.services.interfaces;


import com.argentina_programa.Portfolio.entities.Estudios;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author bra5j
 */
@Service
public interface IEstudiosService {
    List<Estudios> findAll();
    
    Estudios findByEstudiosID(int id); 
    
    void save(Estudios elem);
    
    void saveAll( List < Estudios > elems);
    
    void deleteById (int id );
    
    void update (Estudios estudio, int id);
}
