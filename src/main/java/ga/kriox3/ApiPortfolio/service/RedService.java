
package ga.kriox3.ApiPortfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ga.kriox3.ApiPortfolio.repository.RedRepository;
import java.util.List;
import ga.kriox3.ApiPortfolio.model.red;

@Service
public class RedService implements IRedService{
    
    @Autowired
    private RedRepository netRepository;
    
    @Override
    public List<red> getRed(){
        List<red> listaRed = netRepository.findAll();
        return listaRed;
    }
    
    @Override
    public void saveRed(red net){
        netRepository.save(net);
    }
    
    @Override
    public void deleteRed(Long id){
        netRepository.deleteById(id);
    }
    
    @Override
    public red findRed(Long id){
        red net = netRepository.findById(id).orElse(null);
        return net;
    }
}
