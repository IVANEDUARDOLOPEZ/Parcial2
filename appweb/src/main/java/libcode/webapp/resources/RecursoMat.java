/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocios.DataServiceMat;

/**
 *
 * @author ivan
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/materias")
public class RecursoMat {

    @EJB
    DataServiceMat servicioMateria;

    @GET
    public Response getMaterias() {
        List<Materia> materias = servicioMateria.getMaterias();
        return Response.ok(materias).build();
    }

    @POST
    public Response saveMateria(Materia materia) {
        servicioMateria.saveMateria(materia);
        return Response.ok("Materia creada correctamente").build();
    }

    @PUT
    @Path("/{id}")
    public Response editMateria(@PathParam("id") Integer id, Materia materia) {
        materia.setId(id);
        servicioMateria.editMateria(materia);
        return Response.ok("Materia editada correctamente").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMateria(@PathParam("id") Integer id) {
        servicioMateria.deleteMateria(new Materia(id));
        return Response.ok("Materia eliminada correctamente").build();
    }
    
}
