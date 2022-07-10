/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentina_programa.Portfolio.repository;

import com.argentina_programa.Portfolio.entities.Experiencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bra5j
 */
@Repository
public interface ExperienciaRepository extends CrudRepository<Experiencia,Integer>{
    
}
