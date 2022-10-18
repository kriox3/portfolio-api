package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.model.habilidad;
import ga.kriox3.ApiPortfolio.service.IHabilidadService;
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
public class HabilidadController {

    @Autowired
    private IHabilidadService interHabilidad;
    
    @Autowired
    private PersonaController persController;

    @GetMapping("habilidades/traer")
    public List<habilidad> getHabilidad() {
        return interHabilidad.getHabilidad();
    }

    @PostMapping("habilidades/crear")
    public String createHabilidad(@RequestBody habilidad hab) {
        hab.setPersona(persController.devolverCliente());
        interHabilidad.saveHabilidad(hab);
        return "La habilidad fue agregada correctamente";
    }

    @DeleteMapping("habilidades/borrar/{id}")
    public String deleteHabilidad(@PathVariable Long id) {
        interHabilidad.deleteHabilidad(id);
        return "La habilidad fue eliminada correctamente";
    }

    @PutMapping("habilidades/editar/{id}")
    public habilidad editHabilidad(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("porcentaje") String nuevoPorcentaje) {
        habilidad hab = interHabilidad.findHabilidad(id);
        hab.setPersona(persController.devolverCliente());
        hab.setNombre(nuevoNombre);
        hab.setPorcentaje(nuevoPorcentaje);

        interHabilidad.saveHabilidad(hab);

        return hab;
    }

}
