
package ga.kriox3.ApiPortfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ga.kriox3.ApiPortfolio.repository.PersonaRepository;
import java.util.List;
import ga.kriox3.ApiPortfolio.model.persona;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository persoRepository;
    
    @Override
    public List<persona> getPersonas(){
        List<persona> listaPersonas = persoRepository.findAll();
        return listaPersonas;
    }
    
    @Override
    public void savePersona(persona perso){
        persoRepository.save(perso);
    }
    
    @Override
    public void deletePersona(Long id){
        persoRepository.deleteById(id);
    }
    
    @Override
    public persona findPersona(Long id){
        persona perso = persoRepository.findById(id).orElse(null);
        return perso;
    }
}
