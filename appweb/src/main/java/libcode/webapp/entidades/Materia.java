/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "materia")
public class Materia implements Serializable {
 
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_id_seq")
    @SequenceGenerator(name = "materia_id_seq", sequenceName = "materia_id_seq", allocationSize = 1)
    @Column(name = "id")
    
    private Integer id;
    @Column(name = "nombremat")
    private String nombremat;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "codigo_materia")
    private String codigo_materia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombremat() {
        return nombremat;
    }

    public void setNombremat(String nombremat) {
        this.nombremat = nombremat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo_materia() {
        return codigo_materia;
    }

    public void setCodigo_materia(String codigo_materia) {
        this.codigo_materia = codigo_materia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombremat=" + nombremat + ", descripcion=" + descripcion + ", codigo_materia=" + codigo_materia + '}';
    }

    public Materia(Integer id) {
        this.id = id;
    }

    public Materia(Integer id, String nombremat, String descripcion, String codigo_materia) {
        this.id = id;
        this.nombremat = nombremat;
        this.descripcion = descripcion;
        this.codigo_materia = codigo_materia;
    }
    
    public Materia() {
       
    }
        public Materia(Integer id, String nombremat) {
        this.id = id;
        this.nombremat = nombremat;
        }
}