package libcode.webapp.negocios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.webapp.entidades.Inscripcion;

@Stateless
public class DataServiceInscripcion {

    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;

    public List<Inscripcion> getInscripciones() {
        return entityManager.createQuery("SELECT i FROM Inscripcion i", Inscripcion.class).getResultList();
    }

    @Transactional
    public void saveInscripcion(Inscripcion inscripcion) {
        entityManager.persist(inscripcion);
    }

    @Transactional
    public void editInscripcion(Inscripcion inscripcion) {
        entityManager.merge(inscripcion);
    }

    @Transactional
    public void deleteInscripcion(Inscripcion inscripcion) {
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }
}
 
