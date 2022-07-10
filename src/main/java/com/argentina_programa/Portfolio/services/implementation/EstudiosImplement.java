
package com.argentina_programa.Portfolio.services.implementation;

import com.argentina_programa.Portfolio.entities.Estudios;
import com.argentina_programa.Portfolio.repository.EstudiosRepository;
import com.argentina_programa.Portfolio.services.interfaces.IEstudiosService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author bra5j
 */
@Component
public class EstudiosImplement implements IEstudiosService{

    @Autowired
    private EstudiosRepository EstuRepo;
    
    @Override
    public List<Estudios> findAll() {
        List<Estudios> estudios = new ArrayList <>();
        for(Estudios i: this.EstuRepo.findAll()){
            estudios.add(i);
        }
        return estudios;
    }

    @Override
    public Estudios findByEstudiosID(int id) {
        return this.EstuRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Estudios elem) {
        this.EstuRepo.save(elem);
    }

    @Override
    public void saveAll(List<Estudios> elems) {
        this.EstuRepo.saveAll(elems);
    }

    @Override
    public void deleteById(int id) {
        this.EstuRepo.deleteById(id);
    }

    @Override
    public void update(Estudios estudio, int id) {
        Estudios estudioR = this.EstuRepo.findById(id).orElse(null);
        if(!estudio.getLeyenda().isEmpty() && estudioR != null){
            estudioR.setLeyenda(estudio.getLeyenda());
            this.EstuRepo.save(estudioR);
        }
    }
    
}
