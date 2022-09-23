
package ga.kriox3.ApiPortfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ga.kriox3.ApiPortfolio.repository.RedesRepository;
import java.util.List;
import ga.kriox3.ApiPortfolio.model.redes;

@Service
public class RedesService implements IRedesService{
    
    @Autowired
    private RedesRepository netsRepository;
    
    @Override
    public List<redes> getRedes(){
        List<redes> listaRedes = netsRepository.findAll();
        return listaRedes;
    }
    
    @Override
    public void saveRedes(redes nets){
        netsRepository.save(nets);
    }
    
    @Override
    public void deleteRedes(Long id){
        netsRepository.deleteById(id);
    }
    
    @Override
    public redes findRedes(Long id){
        redes nets = netsRepository.findById(id).orElse(null);
        return nets;
    }
}
