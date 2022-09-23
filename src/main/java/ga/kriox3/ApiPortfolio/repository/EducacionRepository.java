
package ga.kriox3.ApiPortfolio.repository;

import ga.kriox3.ApiPortfolio.model.educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<educacion, Long>{
    
}
