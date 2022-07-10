/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentina_programa.Portfolio.services.interfaces;

import com.argentina_programa.Portfolio.entities.Skills;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author bra5j
 */
@Service
public interface ISkillsService {
     List<Skills> findAll();
    
    Skills findBySkillsID(int id); 
    
    void save(Skills elem);
    
    void saveAll( List < Skills > elems);
    
    void deleteById (int id );
    
    void update (Skills estudio, int id);
}
