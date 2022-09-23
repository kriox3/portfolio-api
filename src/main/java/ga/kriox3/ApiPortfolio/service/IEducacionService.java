
package ga.kriox3.ApiPortfolio.service;

import ga.kriox3.ApiPortfolio.model.educacion;
import java.util.List;

public interface IEducacionService {
    
    public List<educacion> getEducacion();
    
    public void saveEducacion(educacion educa);
    
    public void deleteEducacion(Long id);
    
    public educacion findEducacion (Long id);
    
    
}
