package cl.keanzato.app.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.keanzato.app.core.Usuario;

public interface InterfaceUsuario {

	public boolean agregar(Usuario usuario)throws SQLException, ClassNotFoundException;
	
	public boolean login(String usuario, String password)throws SQLException, ClassNotFoundException;
	
	public List<Usuario> lista()throws SQLException, ClassNotFoundException;
}
