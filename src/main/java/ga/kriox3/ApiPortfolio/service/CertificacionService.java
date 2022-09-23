
package ga.kriox3.ApiPortfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ga.kriox3.ApiPortfolio.repository.CertificacionRepository;
import java.util.List;
import ga.kriox3.ApiPortfolio.model.certificacion;

@Service
public class CertificacionService implements ICertificacionService{
    
    @Autowired
    private CertificacionRepository certRepository;
    
    @Override
    public List<certificacion> getCertificacion(){
        List<certificacion> listaCertificaciones = certRepository.findAll();
        return listaCertificaciones;
    }
    
    @Override
    public void saveCertificacion(certificacion cert){
        certRepository.save(cert);
    }
    
    @Override
    public void deleteCertificacion(Long id){
        certRepository.deleteById(id);
    }
    
    @Override
    public certificacion findCertificacion(Long id){
        certificacion cert = certRepository.findById(id).orElse(null);
        return cert;
    }
}
