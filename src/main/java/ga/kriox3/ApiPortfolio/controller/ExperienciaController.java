package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.model.experiencia;
import ga.kriox3.ApiPortfolio.service.IExperienciaService;
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
public class ExperienciaController {

    @Autowired
    private IExperienciaService interExperiencia;
    
    @Autowired
    private PersonaController persController;

    @GetMapping("experiencia/traer")
    public List<experiencia> getExperiencia() {
        return interExperiencia.getExperiencia();
    }

    @PostMapping("experiencia/crear")
    public String createExperiencia(@RequestBody experiencia exp) {
        exp.setPersona(persController.devolverCliente());
        interExperiencia.saveExperiencia(exp);
        return "La experiencia fue agregada correctamente";
    }

    @DeleteMapping("experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id) {
        interExperiencia.deleteExperiencia(id);
        return "La experiencia fue eliminada correctamente";
    }

    @PutMapping("experiencia/editar/{id}")
    public experiencia editExperiencia(@PathVariable Long id,
            @RequestParam("establecimiento") String nuevoEstablecimiento,
            @RequestParam("ocupacion") String nuevaOcupacion,
            @RequestParam("desde") String nuevoDesde,
            @RequestParam("hasta") String nuevoHasta,
            @RequestParam("actual") Boolean nuevaActual) {
        experiencia exp = interExperiencia.findExperiencia(id);
        exp.setPersona(persController.devolverCliente());
        exp.setEstablecimiento(nuevoEstablecimiento);
        exp.setOcupacion(nuevaOcupacion);
        exp.setDesde(nuevoDesde);
        exp.setHasta(nuevoHasta);
        exp.setActual(nuevaActual);

        interExperiencia.saveExperiencia(exp);

        return exp;
    }

}
