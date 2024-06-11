/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.negocios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.webapp.entidades.Materia;

@Stateless
public class DataServiceMat {
    
    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;
    
    public List<Materia> getMaterias() {
        Query query = entityManager.createQuery("SELECT m FROM Materia m ORDER BY m.id ASC");
        List<Materia> materias = query.getResultList();
        return materias;
    }
    
    @Transactional
    public void saveMateria(Materia materia) {
        entityManager.persist(materia);
    }
    
    @Transactional
    public void editMateria(Materia materia) {
        entityManager.merge(materia);
    }
    
    @Transactional
    public void deleteMateria(Materia materia) {
        Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
        entityManager.remove(materiaEliminar);
    }
}
