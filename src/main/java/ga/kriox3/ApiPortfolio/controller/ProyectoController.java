package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.model.proyecto;
import ga.kriox3.ApiPortfolio.service.IProyectoService;
import java.util.Date;
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
public class ProyectoController {

    @Autowired
    private IProyectoService interProyecto;
    
    @Autowired
    private PersonaController persController;

    @GetMapping("proyectos/traer")
    public List<proyecto> getProyecto() {
        return interProyecto.getProyecto();
    }

    @PostMapping("proyectos/crear")
    public String createProyecto(@RequestBody proyecto proj) {
        proj.setPersona(persController.devolverCliente());
        interProyecto.saveProyecto(proj);
        return "El proyecto fue agregado correctamente";
    }

    @DeleteMapping("proyectos/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id) {
        interProyecto.deleteProyecto(id);
        return "El proyecto fue eliminado correctamente";
    }

    @PutMapping("proyectos/editar/{id}")
    public proyecto editProyecto(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("informacion") String nuevaInfo,
            @RequestParam("fecha") String nuevaFecha,
            @RequestParam("accesoUrl") String nuevoAcceso) {
        proyecto proj = interProyecto.findProyecto(id);
        proj.setPersona(persController.devolverCliente());
        proj.setNombre(nuevoNombre);
        proj.setInformacion(nuevaInfo);
        proj.setFecha(nuevaFecha);
        proj.setAccesoUrl(nuevoAcceso);
        

        interProyecto.saveProyecto(proj);

        return proj;
    }

}
