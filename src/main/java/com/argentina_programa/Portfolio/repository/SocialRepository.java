/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentina_programa.Portfolio.repository;

import com.argentina_programa.Portfolio.entities.Social;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bra5j
 */
public interface SocialRepository extends CrudRepository <Social,Integer>{
    @Transactional ( readOnly = true)
    Optional <Social> findByRedSocial (String red_social);
}
