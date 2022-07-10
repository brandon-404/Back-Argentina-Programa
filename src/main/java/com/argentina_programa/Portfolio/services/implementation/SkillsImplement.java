
package com.argentina_programa.Portfolio.services.implementation;

import com.argentina_programa.Portfolio.entities.Skills;
import com.argentina_programa.Portfolio.repository.SkillsRepository;
import com.argentina_programa.Portfolio.services.interfaces.ISkillsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author bra5j
 */
@Component
public class SkillsImplement implements ISkillsService{
    @Autowired
    private SkillsRepository skillsRepo;
    
    @Override
    public List<Skills> findAll() {
        List<Skills> estudios = new ArrayList <>();
        for(Skills i: this.skillsRepo.findAll()){
            estudios.add(i);
        }
        return estudios;
    }

    @Override
    public Skills findBySkillsID(int id) {
        return this.skillsRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Skills elem) {
        this.skillsRepo.save(elem);
    }

    @Override
    public void saveAll(List<Skills> elems) {
        this.skillsRepo.saveAll(elems);
    }

    @Override
    public void deleteById(int id) {
        this.skillsRepo.deleteById(id);
    }

    @Override
    public void update(Skills estudio, int id) {
         Skills expR = this.skillsRepo.findById(id).orElse(null);
        if(!estudio.getNombre_tecnologia().isEmpty() && expR != null){
            expR.setNombre_tecnologia(estudio.getNombre_tecnologia());
            if ( estudio.getSkill_lvl() != 0 ){
                expR.setSkill_lvl(estudio.getSkill_lvl());
            }
            this.skillsRepo.save(expR);
        }
    }
 }
    

