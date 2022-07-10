
package com.argentina_programa.Portfolio.repository;

import com.argentina_programa.Portfolio.entities.Users;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bra5j
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>{
    
    @Transactional ( readOnly = true)
    Optional<Users>findByUsername(String username);
    
}
