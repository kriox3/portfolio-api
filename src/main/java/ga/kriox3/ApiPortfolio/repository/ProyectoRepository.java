
package ga.kriox3.ApiPortfolio.repository;

import ga.kriox3.ApiPortfolio.model.proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<proyecto, Long>{
    
}
