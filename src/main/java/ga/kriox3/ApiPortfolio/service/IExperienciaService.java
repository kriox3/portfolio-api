
package ga.kriox3.ApiPortfolio.service;

import ga.kriox3.ApiPortfolio.model.experiencia;
import java.util.List;

public interface IExperienciaService {
    
    public List<experiencia> getExperiencia();
    
    public void saveExperiencia(experiencia exp);
    
    public void deleteExperiencia(Long id);
    
    public experiencia findExperiencia (Long id);
    
    
}
