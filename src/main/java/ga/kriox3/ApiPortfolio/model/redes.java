package ga.kriox3.ApiPortfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class redes {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @ManyToOne()
    @JoinColumn(name = "red_id")
    private red red;
    
    private String accesoUrl;
    
    @ManyToOne()
    @JoinColumn(name = "persona_id")
    @JsonIgnore
    private persona persona;
    
}
