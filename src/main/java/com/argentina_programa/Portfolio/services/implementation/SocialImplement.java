
package com.argentina_programa.Portfolio.services.implementation;
import com.argentina_programa.Portfolio.entities.Social;
import com.argentina_programa.Portfolio.repository.SocialRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.argentina_programa.Portfolio.services.interfaces.ISocialService;

/**
 *
 * @author bra5j
 */
@Component
public class SocialImplement implements ISocialService{
    
    @Autowired
    private SocialRepository socialRepo;
    
    @Override
    public List<Social> findAll() {
        List<Social> estudios = new ArrayList <>();
        
        for(Social i: this.socialRepo.findAll()){
            estudios.add(i);
        }
        return estudios;
    }

    @Override
    public Social findBySocialID(int userId) {
        return this.socialRepo.findById(userId).orElse(null);
    }

    @Override
    public void save(Social user) {
        this.socialRepo.save(user);
    }

    @Override
    public void saveAll(List<Social> users) {
        this.socialRepo.saveAll(users);
    }

    @Override
    public void deleteById(int userId) {
        this.socialRepo.deleteById(userId);
    }

    @Override
    public void update(Social user, int id) {
        Social expR = this.socialRepo.findById(id).orElse(null);
        if(!user.getRedSocial().isEmpty() && expR != null){
            expR.setRedSocial(user.getRedSocial());
            if ( !user.getLink().isEmpty() ){
                expR.setLink(user.getLink());
            }
            this.socialRepo.save(expR);
        }
    }

    @Override
    public Social findByRedSocial(String red_social) {
        return this.socialRepo.findByRedSocial(red_social).orElse(null);
    }
    
}
