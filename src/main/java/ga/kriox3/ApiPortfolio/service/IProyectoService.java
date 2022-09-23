
package ga.kriox3.ApiPortfolio.service;

import ga.kriox3.ApiPortfolio.model.proyecto;
import java.util.List;

public interface IProyectoService {
    
    public List<proyecto> getProyecto();
    
    public void saveProyecto(proyecto proj);
    
    public void deleteProyecto(Long id);
    
    public proyecto findProyecto (Long id);
    
    
}
