
package com.argentina_programa.Portfolio.services.implementation;

import com.argentina_programa.Portfolio.entities.Experiencia;
import com.argentina_programa.Portfolio.repository.ExperienciaRepository;
import org.springframework.stereotype.Component;
import com.argentina_programa.Portfolio.services.interfaces.IExperienciaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bra5j
 */
@Component
public class ExperienciaImpelement implements IExperienciaService{
    @Autowired
    private ExperienciaRepository ExpRepo;

    @Override
    public List<Experiencia> findAll() {
        List<Experiencia> estudios = new ArrayList <>();
        for(Experiencia i: this.ExpRepo.findAll()){
            estudios.add(i);
        }
        return estudios;
    }

    @Override
    public Experiencia findByExpID(int id) {
          return this.ExpRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Experiencia elem) {
        this.ExpRepo.save(elem);
    }

    @Override
    public void saveAll(List<Experiencia> elems) {
        this.ExpRepo.saveAll(elems);
    }

    @Override
    public void deleteById(int id) {
         this.ExpRepo.deleteById(id);
    }

    @Override
    public void update(Experiencia estudio, int id) {
          Experiencia estudioR = this.ExpRepo.findById(id).orElse(null);
        if(!estudio.getLeyenda().isEmpty() && estudioR != null){
            estudioR.setLeyenda(estudio.getLeyenda());
            this.ExpRepo.save(estudioR);
        }
    }
    
}
