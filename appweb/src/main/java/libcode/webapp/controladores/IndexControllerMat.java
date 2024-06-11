/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocios.DataServiceMat;

/**
 *
 * @author ivan
 */
@Named
@RequestScoped
public class IndexControllerMat {

    private List<Materia> materiasList = new ArrayList<>();

    private Materia materia = new Materia();

    @EJB
    DataServiceMat servicioMateria;

    @PostConstruct
    public void cargarMaterias() {
        materiasList = servicioMateria.getMaterias();
    }

    public void guardarMateria() {
        if(materia.getId()!=null){
       servicioMateria.editMateria(materia);
            
        }else 
        { servicioMateria.saveMateria(materia);
        
        }
        materia = new Materia();
        cargarMaterias();

    }

    public void llenarFormMat(Materia materia) {
        this.materia.setId(materia.getId());
        this.materia.setNombremat(materia.getNombremat());
        this.materia.setDescripcion(materia.getDescripcion());
        this.materia.setCodigo_materia(materia.getCodigo_materia());
    }

    public void eliminarMateria(Materia materia){
        servicioMateria.deleteMateria(materia);
        cargarMaterias();
    }
    //** getters and setters
    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }

}
