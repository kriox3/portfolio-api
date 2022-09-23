
package ga.kriox3.ApiPortfolio.service;

import java.util.List;
import ga.kriox3.ApiPortfolio.model.certificacion;

public interface ICertificacionService {
    
    public List<certificacion> getCertificacion();
    
    public void saveCertificacion(certificacion cert);
    
    public void deleteCertificacion(Long id);
    
    public certificacion findCertificacion (Long id);
    
    
}
