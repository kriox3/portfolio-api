package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.dto.PortfolioDTO;
import ga.kriox3.ApiPortfolio.model.certificacion;
import ga.kriox3.ApiPortfolio.model.educacion;
import ga.kriox3.ApiPortfolio.model.experiencia;
import ga.kriox3.ApiPortfolio.model.habilidad;
import ga.kriox3.ApiPortfolio.model.proyecto;
import ga.kriox3.ApiPortfolio.model.persona;
import ga.kriox3.ApiPortfolio.model.redes;
import ga.kriox3.ApiPortfolio.service.ICertificacionService;
import ga.kriox3.ApiPortfolio.service.IEducacionService;
import ga.kriox3.ApiPortfolio.service.IExperienciaService;
import ga.kriox3.ApiPortfolio.service.IHabilidadService;
import ga.kriox3.ApiPortfolio.service.IProyectoService;
import ga.kriox3.ApiPortfolio.service.IPersonaService;
import ga.kriox3.ApiPortfolio.service.IRedesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioDtoController {

    @Autowired
    private ICertificacionService interCertificacion;
    @Autowired
    private IEducacionService interEducacion;
    @Autowired
    private IExperienciaService interExperiencia;
    @Autowired
    private IHabilidadService interHabilidad;
    @Autowired
    private IProyectoService interProyecto;
    @Autowired
    private IPersonaService interPersona;
    @Autowired
    private IRedesService interRedes;

    @GetMapping("/portfolio/datos")
    @ResponseBody
    public PortfolioDTO devolverCliente() {
        
        Long id;
        
        List<persona> personas = interPersona.getPersonas();
        
        id = personas.get(0).getId();
        
        System.out.println(id);

        List<certificacion> cert = interCertificacion.getCertificacion();
        List<educacion> educ = interEducacion.getEducacion();
        List<experiencia> exp = interExperiencia.getExperiencia();
        List<habilidad> hab = interHabilidad.getHabilidad();
        List<proyecto> proj = interProyecto.getProyecto();
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
        port.setCertificaciones(cert);
        port.setEducaciones(educ);
        port.setExperiencias(exp);
        port.setHabilidades(hab);
        port.setProyectos(proj);
        port.setRedes(nets);

        return port;
    }

}
