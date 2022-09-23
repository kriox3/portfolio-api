package ga.kriox3.ApiPortfolio.controller;

import ga.kriox3.ApiPortfolio.model.certificacion;
import ga.kriox3.ApiPortfolio.service.ICertificacionService;
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
public class CertificacionController {

    @Autowired
    private ICertificacionService interCertificacion;

    @GetMapping("certificaciones/traer")
    public List<certificacion> getCertificacion() {
        return interCertificacion.getCertificacion();
    }

    @PostMapping("certificaciones/crear")
    public String createCertificacion(@RequestBody certificacion cert) {
        interCertificacion.saveCertificacion(cert);
        return "La certificacion fue creada correctamente";
    }

    @DeleteMapping("certificaciones/borrar/{id}")
    public String deleteCertificacion(@PathVariable Long id) {
        interCertificacion.deleteCertificacion(id);
        return "La certificacion fue eliminada correctamente";
    }

    @PutMapping("certificaciones/editar/{id}")
    public certificacion editCertificacion(@PathVariable Long id,
            @RequestParam("establecimiento") String nuevoEstablecimiento,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("fecha") Date nuevaFecha,
            @RequestParam("completado") Boolean nuevaCompletado) {
        certificacion cert = interCertificacion.findCertificacion(id);

        cert.setEstablecimiento(nuevoEstablecimiento);
        cert.setTitulo(nuevoTitulo);
        cert.setFecha(nuevaFecha);
        cert.setCompletado(nuevaCompletado);

        interCertificacion.saveCertificacion(cert);

        return cert;
    }

}
