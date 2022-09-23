
package ga.kriox3.ApiPortfolio.repository;

import ga.kriox3.ApiPortfolio.model.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<persona, Long>{
    
}
