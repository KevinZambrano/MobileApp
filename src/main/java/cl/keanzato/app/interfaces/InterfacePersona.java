package cl.keanzato.app.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.keanzato.app.core.Persona;

public interface InterfacePersona {

	public boolean agregar(Persona persona)throws SQLException, ClassNotFoundException;
	
	public boolean validarRut(String rut);
	
	public List<Persona> lista()throws SQLException, ClassNotFoundException;
}
