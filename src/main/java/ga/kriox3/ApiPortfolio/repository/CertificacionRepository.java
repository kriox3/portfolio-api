
package ga.kriox3.ApiPortfolio.repository;

import ga.kriox3.ApiPortfolio.model.certificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificacionRepository extends JpaRepository<certificacion, Long>{
    
}
