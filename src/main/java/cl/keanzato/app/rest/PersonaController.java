package cl.keanzato.app.rest;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cl.keanzato.app.core.Persona;
import cl.keanzato.app.dao.PersonaDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("personas")
public class PersonaController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Persona> listaPersonas() throws ClassNotFoundException{
		try {
            PersonaDao personaDao = new PersonaDao();
            return personaDao.lista();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
	}
}
