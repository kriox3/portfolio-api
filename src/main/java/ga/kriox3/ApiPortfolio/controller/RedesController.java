package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.model.redes;
import ga.kriox3.ApiPortfolio.model.red;
import ga.kriox3.ApiPortfolio.service.IRedesService;
import ga.kriox3.ApiPortfolio.controller.PersonaController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class RedesController {

    @Autowired
    private IRedesService interRedes;
    @Autowired
    private PersonaController persController;

    @GetMapping("redeses/traer")
    public List<redes> getRedes() {
        return interRedes.getRedes();
    }

    @PostMapping("redeses/crear")
    public String createRedes(@RequestBody redes nets) {
        if(nets.getPersona() == null){
            nets.setPersona(persController.devolverCliente());
        }
        interRedes.saveRedes(nets);
        return "La red fue creada correctamente";
    }

    @DeleteMapping("redeses/borrar/{id}")
    public String deleteRedes(@PathVariable Long id) {
        interRedes.deleteRedes(id);
        return "La red fue eliminada correctamente";
    }

    @PutMapping("redeses/editar/{id}")
    public redes editRedes(@PathVariable Long id,
            @RequestParam("red") red nuevaRed,
            @RequestParam("accesoUrl") String nuevoAcceso) {
        redes nets = interRedes.findRedes(id);
        nets.setRed(nuevaRed);
        nets.setAccesoUrl(nuevoAcceso);
        

        interRedes.saveRedes(nets);

        return nets;
    }

}
