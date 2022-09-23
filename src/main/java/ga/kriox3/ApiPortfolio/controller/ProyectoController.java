package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.model.proyecto;
import ga.kriox3.ApiPortfolio.service.IProyectoService;
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
public class ProyectoController {

    @Autowired
    private IProyectoService interProyecto;

    @GetMapping("proyectoes/traer")
    public List<proyecto> getProyecto() {
        return interProyecto.getProyecto();
    }

    @PostMapping("proyectoes/crear")
    public String createProyecto(@RequestBody proyecto proj) {
        interProyecto.saveProyecto(proj);
        return "El proyecto fue creado correctamente";
    }

    @DeleteMapping("proyectoes/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id) {
        interProyecto.deleteProyecto(id);
        return "El proyecto fue eliminado correctamente";
    }

    @PutMapping("proyectoes/editar/{id}")
    public proyecto editProyecto(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("informacion") String nuevaInfo,
            @RequestParam("fecha") Date nuevaFecha,
            @RequestParam("accesoUrl") String nuevoAcceso) {
        proyecto proj = interProyecto.findProyecto(id);

        proj.setNombre(nuevoNombre);
        proj.setInformacion(nuevaInfo);
        proj.setFecha(nuevaFecha);
        proj.setAccesoUrl(nuevoAcceso);
        

        interProyecto.saveProyecto(proj);

        return proj;
    }

}
