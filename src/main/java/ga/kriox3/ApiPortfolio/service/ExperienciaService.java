
package ga.kriox3.ApiPortfolio.service;

import ga.kriox3.ApiPortfolio.model.experiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import ga.kriox3.ApiPortfolio.repository.ExperienciaRepository;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    private ExperienciaRepository expRepository;
    
    @Override
    public List<experiencia> getExperiencia(){
        List<experiencia> listaExperiencia = expRepository.findAll();
        return listaExperiencia;
    }
    
    @Override
    public void saveExperiencia(experiencia exp){
        expRepository.save(exp);
    }
    
    @Override
    public void deleteExperiencia(Long id){
        expRepository.deleteById(id);
    }
    
    @Override
    public experiencia findExperiencia(Long id){
        experiencia exp = expRepository.findById(id).orElse(null);
        return exp;
    }
}
