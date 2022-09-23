package ga.kriox3.ApiPortfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class persona {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String foto;
    private String localidad;
    private String info;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<certificacion> certificaciones;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<educacion> educaciones;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<experiencia> experiencias;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<habilidad> habilidades;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<redes> redes;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<proyecto> proyectos;
    
}
