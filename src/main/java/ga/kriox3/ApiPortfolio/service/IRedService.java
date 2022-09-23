
package ga.kriox3.ApiPortfolio.service;

import java.util.List;
import ga.kriox3.ApiPortfolio.model.red;

public interface IRedService {
    
    public List<red> getRed();
    
    public void saveRed(red net);
    
    public void deleteRed(Long id);
    
    public red findRed (Long id);
    
    
}
