
package ga.kriox3.ApiPortfolio.service;

import ga.kriox3.ApiPortfolio.model.educacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import ga.kriox3.ApiPortfolio.repository.EducacionRepository;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    private EducacionRepository educaRepository;
    
    @Override
    public List<educacion> getEducacion(){
        List<educacion> listaEducacion = educaRepository.findAll();
        return listaEducacion;
    }
    
    @Override
    public void saveEducacion(educacion perso){
        educaRepository.save(perso);
    }
    
    @Override
    public void deleteEducacion(Long id){
        educaRepository.deleteById(id);
    }
    
    @Override
    public educacion findEducacion(Long id){
        educacion educa = educaRepository.findById(id).orElse(null);
        return educa;
    }
}
