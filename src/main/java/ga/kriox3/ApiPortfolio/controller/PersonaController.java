package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.model.persona;
import ga.kriox3.ApiPortfolio.service.IPersonaService;
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
public class PersonaController {

    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping("/personas/ver")
    public persona devolverCliente() {
        return interPersona.findPersona(consultarPrimerId());
    }

    @GetMapping("personas/traer")
    public List<persona> getPersonas() {
        return interPersona.getPersonas();
    }

    @PostMapping("personas/crear")
    public String createPersona(@RequestBody persona perso) {
        interPersona.savePersona(perso);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        interPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("personas/editar/")
    public persona editPersona(@RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("foto") String nuevaFoto,
            @RequestParam("localidad") String nuevaLocalidad,
            @RequestParam("info") String nuevaInfo) {
        persona perso = interPersona.findPersona(consultarPrimerId());

        perso.setId(consultarPrimerId());
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setFoto(nuevaFoto);
        perso.setLocalidad(nuevaLocalidad);
        perso.setInfo(nuevaInfo);

        interPersona.savePersona(perso);

        return perso;
    }   
    
    private Long consultarPrimerId(){
        Long id;
        List<persona> personas = interPersona.getPersonas();
        id = personas.get(0).getId();
        
        return id;
    }

}
