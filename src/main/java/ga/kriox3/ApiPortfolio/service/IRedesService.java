
package ga.kriox3.ApiPortfolio.service;

import java.util.List;
import ga.kriox3.ApiPortfolio.model.redes;

public interface IRedesService {
    
    public List<redes> getRedes();
    
    public void saveRedes(redes nets);
    
    public void deleteRedes(Long id);
    
    public redes findRedes (Long id);
    
    
}
