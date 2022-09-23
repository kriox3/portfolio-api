
package ga.kriox3.ApiPortfolio.service;

import ga.kriox3.ApiPortfolio.model.habilidad;
import java.util.List;

public interface IHabilidadService {
    
    public List<habilidad> getHabilidad();
    
    public void saveHabilidad(habilidad hab);
    
    public void deleteHabilidad(Long id);
    
    public habilidad findHabilidad (Long id);
    
    
}
