package ga.kriox3.ApiPortfolio.repository;

import ga.kriox3.ApiPortfolio.entity.Rol;
import ga.kriox3.ApiPortfolio.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}