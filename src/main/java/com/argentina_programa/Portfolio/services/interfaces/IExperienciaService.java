/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentina_programa.Portfolio.services.interfaces;

import com.argentina_programa.Portfolio.entities.Experiencia;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author bra5j
 */
@Service
public interface IExperienciaService {
    List<Experiencia> findAll();
    
    Experiencia findByExpID(int id); 
    
    void save(Experiencia elem);
    
    void saveAll( List < Experiencia > elems);
    
    void deleteById (int id );
    
    void update (Experiencia estudio, int id);
}
