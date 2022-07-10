/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentina_programa.Portfolio.services.interfaces;

import com.argentina_programa.Portfolio.entities.Social;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author bra5j
 */
@Service
public interface ISocialService {
     List<Social> findAll();
    
    Social findByRedSocial(String red_social);
    
    Social findBySocialID(int userId);   
    
    void save(Social user);
    
    void saveAll( List < Social > users);
    
    void deleteById (int userId );
    
    void update (Social user, int id);
}
