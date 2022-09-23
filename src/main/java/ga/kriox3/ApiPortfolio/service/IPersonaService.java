
package ga.kriox3.ApiPortfolio.service;

import java.util.List;
import ga.kriox3.ApiPortfolio.model.persona;

public interface IPersonaService {
    
    public List<persona> getPersonas();
    
    public void savePersona(persona perso);
    
    public void deletePersona(Long id);
    
    public persona findPersona (Long id);
    
    
}
