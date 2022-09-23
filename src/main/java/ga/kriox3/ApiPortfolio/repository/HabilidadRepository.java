
package ga.kriox3.ApiPortfolio.repository;

import ga.kriox3.ApiPortfolio.model.habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<habilidad, Long>{
    
}
