
package ga.kriox3.ApiPortfolio.service;

import ga.kriox3.ApiPortfolio.model.habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import ga.kriox3.ApiPortfolio.repository.HabilidadRepository;

@Service
public class HabilidadService implements IHabilidadService{
    
    @Autowired
    private HabilidadRepository habRepository;
    
    @Override
    public List<habilidad> getHabilidad(){
        List<habilidad> listaHabilidad = habRepository.findAll();
        return listaHabilidad;
    }
    
    @Override
    public void saveHabilidad(habilidad hab){
        habRepository.save(hab);
    }
    
    @Override
    public void deleteHabilidad(Long id){
        habRepository.deleteById(id);
    }
    
    @Override
    public habilidad findHabilidad(Long id){
        habilidad hab = habRepository.findById(id).orElse(null);
        return hab;
    }
}
