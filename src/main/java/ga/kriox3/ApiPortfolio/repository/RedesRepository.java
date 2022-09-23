
package ga.kriox3.ApiPortfolio.repository;

import ga.kriox3.ApiPortfolio.model.redes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesRepository extends JpaRepository<redes, Long>{
    
}
