package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.dto.PortfolioDTO;
import ga.kriox3.ApiPortfolio.model.experiencia;
import ga.kriox3.ApiPortfolio.model.persona;
import ga.kriox3.ApiPortfolio.model.redes;
import ga.kriox3.ApiPortfolio.service.IExperienciaService;
import ga.kriox3.ApiPortfolio.service.IPersonaService;
import ga.kriox3.ApiPortfolio.service.IRedesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioDtoController {

    @Autowired
    private IExperienciaService interExperiencia;
    @Autowired
    private IPersonaService interPersona;
    @Autowired
    private IRedesService interRedes;

    @GetMapping("/portfolio/datos")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public PortfolioDTO devolverCliente() {
        
        Long id;
        
        List<persona> personas = interPersona.getPersonas();
        
        id = personas.get(0).getId();
        
        System.out.println(id);
        List<experiencia> exp = interExperiencia.getExperiencia();
        persona pers = interPersona.findPersona(id);
        List<redes> nets = interRedes.getRedes();

        PortfolioDTO port = new PortfolioDTO();

        exp.forEach((p) -> {
            if (p.getActual()) {
                port.setCargo_persona(p.getOcupacion());
                port.setOficina_persona(p.getEstablecimiento());
            }
        });

        port.setId_persona(pers.getId());
        port.setNombre_persona(pers.getNombre());
        port.setApellido_persona(pers.getApellido());
        port.setFoto_persona(pers.getFoto());
        port.setLocalidad_persona(pers.getLocalidad());
        port.setInfo_persona(pers.getInfo());
        port.setRedes(nets);

        return port;
    }

}
