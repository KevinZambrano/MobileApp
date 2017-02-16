package cl.keanzato.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.keanzato.app.conexion.ConexionBD;
import cl.keanzato.app.core.Usuario;
import cl.keanzato.app.interfaces.InterfaceUsuario;

public class UsuarioDao implements InterfaceUsuario{

	public boolean agregar(Usuario usuario) throws SQLException, ClassNotFoundException {
		try{
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection().prepareStatement("insert into usuario values(?,?,?,?)");
			consulta.setString(1, usuario.getIdusuario());
			consulta.setInt(2, usuario.getRut());
			consulta.setString(3, usuario.getPassword());
			consulta.setString(4, usuario.getCorreo());
			
			consulta.execute();
			return true;
		}catch(SQLException ex){
			return false;
		}catch(Exception ex){
			return false;
		}
	}

	public boolean login(String usuario, String password) throws SQLException, ClassNotFoundException {
		if(usuario!=null && password!=null){
			for (Usuario  u: lista()) {
				if(u.getIdusuario().equals(usuario)){
					if(u.getPassword().equals(password)){
						return true;
					}
				}
			}
		}
		return false;
	}

	public List<Usuario> lista() throws SQLException, ClassNotFoundException {
		try{
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection().prepareStatement("select * from usuario");
			ResultSet rst = consulta.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();
			while(rst.next()){
				usuarios.add(parser(rst));
			}
			return usuarios;
		}catch(SQLException ex){
			return null;
		}catch(Exception ex){
			return null;
		}
		
	}
	
	private Usuario parser(ResultSet rst) throws SQLException{
		Usuario usuario = new Usuario();
		
		usuario.setIdusuario(rst.getString("idusuario"));
		usuario.setRut(rst.getInt("rut"));
		usuario.setPassword(rst.getString("password"));
		usuario.setCorreo(rst.getString("correo"));
		
		return usuario;
	}

}
