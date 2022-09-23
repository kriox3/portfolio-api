
package ga.kriox3.ApiPortfolio.repository;

import ga.kriox3.ApiPortfolio.model.experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<experiencia, Long>{
    
}
