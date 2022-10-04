package ga.kriox3.ApiPortfolio.service;

import ga.kriox3.ApiPortfolio.entity.Rol;
import ga.kriox3.ApiPortfolio.enums.RolNombre;
import ga.kriox3.ApiPortfolio.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
}