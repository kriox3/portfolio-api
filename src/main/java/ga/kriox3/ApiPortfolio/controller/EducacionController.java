package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.model.educacion;
import ga.kriox3.ApiPortfolio.service.IEducacionService;
import java.util.Date;
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
public class EducacionController {

    @Autowired
    private IEducacionService interEducacion;

    @GetMapping("educaciones/traer")
    public List<educacion> getEducacion() {
        return interEducacion.getEducacion();
    }

    @PostMapping("educaciones/crear")
    public String createEducacion(@RequestBody educacion educ) {
        interEducacion.saveEducacion(educ);
        return "La educacion fue creada correctamente";
    }

    @DeleteMapping("educaciones/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id) {
        interEducacion.deleteEducacion(id);
        return "La educacion fue eliminada correctamente";
    }

    @PutMapping("educaciones/editar/{id}")
    public educacion editEducacion(@PathVariable Long id,
            @RequestParam("establecimiento") String nuevoEstablecimiento,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("fecha") Date nuevaFecha,
            @RequestParam("completado") Boolean nuevaCompletado) {
        educacion educ = interEducacion.findEducacion(id);

        educ.setEstablecimiento(nuevoEstablecimiento);
        educ.setTitulo(nuevoTitulo);
        educ.setFecha(nuevaFecha);
        educ.setCompletado(nuevaCompletado);

        interEducacion.saveEducacion(educ);

        return educ;
    }

}
