package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.negocios.DataServiceInscripcion;

@Named
@RequestScoped
public class IndexControllerInscripcion {
    private List<Inscripcion> inscripcionesList = new ArrayList<>();
    private Inscripcion inscripcion = new Inscripcion(); // Agregar instancia de inscripción

    @EJB private DataServiceInscripcion servicioInscripcion;
    
    @PostConstruct
    public void cargarInscripciones() {
        inscripcionesList = servicioInscripcion.getInscripciones();
}
    public void guardarInscripcion() {
        servicioInscripcion.saveInscripcion(inscripcion);
        inscripcion = new Inscripcion();
        cargarInscripciones();
    }
    
    public List<Inscripcion> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }
    
    
    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
    public Inscripcion getInscripcion() {
        return inscripcion;
    }
}
