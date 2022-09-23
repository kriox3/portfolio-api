package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.model.red;
import ga.kriox3.ApiPortfolio.service.IRedService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedController {

    @Autowired
    private IRedService interRed;

    @GetMapping("redes/traer")
    public List<red> getRed() {
        return interRed.getRed();
    }

    @PostMapping("redes/crear")
    public String createRed(@RequestBody red net) {
        interRed.saveRed(net);
        return "La red fue creada correctamente";
    }

    @DeleteMapping("redes/borrar/{id}")
    public String deleteRed(@PathVariable Long id) {
        interRed.deleteRed(id);
        return "La red fue eliminada correctamente";
    }

    @PutMapping("redes/editar/{id}")
    public red editRed(@PathVariable Long id,
            @RequestParam("red") String nuevaRed) {
        red net = interRed.findRed(id);

        net.setRed(nuevaRed);        

        interRed.saveRed(net);

        return net;
    }

}
