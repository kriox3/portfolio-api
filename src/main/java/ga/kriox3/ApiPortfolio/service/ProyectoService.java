
package ga.kriox3.ApiPortfolio.service;

import ga.kriox3.ApiPortfolio.model.proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import ga.kriox3.ApiPortfolio.repository.ProyectoRepository;

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private ProyectoRepository projRepository;
    
    @Override
    public List<proyecto> getProyecto(){
        List<proyecto> listaProyecto = projRepository.findAll();
        return listaProyecto;
    }
    
    @Override
    public void saveProyecto(proyecto proj){
        projRepository.save(proj);
    }
    
    @Override
    public void deleteProyecto(Long id){
        projRepository.deleteById(id);
    }
    
    @Override
    public proyecto findProyecto(Long id){
        proyecto proj = projRepository.findById(id).orElse(null);
        return proj;
    }
}
