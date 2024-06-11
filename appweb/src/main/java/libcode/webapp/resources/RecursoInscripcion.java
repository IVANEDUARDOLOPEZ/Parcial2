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
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.negocios.DataServiceInscripcion;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripciones")
public class RecursoInscripcion {

    @EJB
    DataServiceInscripcion servicioInscripcion;

    @GET
    public Response getInscripciones() {
        List<Inscripcion> inscripciones = servicioInscripcion.getInscripciones();
        return Response.ok(inscripciones).build();
    }

    @POST
    public Response saveInscripcion(Inscripcion inscripcion) {
        servicioInscripcion.saveInscripcion(inscripcion);
        return Response.ok("Inscripción creada correctamente").build();
    }

    @PUT
    @Path("/{id}")
    public Response editInscripcion(@PathParam("id") Integer id, Inscripcion inscripcion) {
        inscripcion.setId(id);
        servicioInscripcion.editInscripcion(inscripcion);
        return Response.ok("Inscripción editada correctamente").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteInscripcion(@PathParam("id") Integer id) {
        servicioInscripcion.deleteInscripcion(new Inscripcion(id));
        return Response.ok("Inscripción eliminada correctamente").build();
    }
}
