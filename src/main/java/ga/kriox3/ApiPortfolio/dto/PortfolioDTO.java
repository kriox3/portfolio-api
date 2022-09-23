
package ga.kriox3.ApiPortfolio.dto;

import ga.kriox3.ApiPortfolio.model.certificacion;
import ga.kriox3.ApiPortfolio.model.educacion;
import ga.kriox3.ApiPortfolio.model.experiencia;
import ga.kriox3.ApiPortfolio.model.habilidad;
import ga.kriox3.ApiPortfolio.model.proyecto;
import ga.kriox3.ApiPortfolio.model.redes;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PortfolioDTO implements Serializable{
    
    private Long id_persona;
    private String nombre_persona;
    private String apellido_persona;
    private String foto_persona;
    private String cargo_persona;
    private String oficina_persona;
    private String localidad_persona;
    private String info_persona;
    
    private List<certificacion> certificaciones;
    private List<educacion> educaciones;
    private List<experiencia> experiencias;
    private List<habilidad> habilidades;
    private List<proyecto> proyectos;
    private List<redes> redes;    
 
}
