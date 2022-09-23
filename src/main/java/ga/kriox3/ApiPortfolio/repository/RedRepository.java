
package ga.kriox3.ApiPortfolio.repository;

import ga.kriox3.ApiPortfolio.model.red;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedRepository extends JpaRepository<red, Long>{
    
}
