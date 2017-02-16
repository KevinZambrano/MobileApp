package cl.keanzato.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.keanzato.app.conexion.ConexionBD;
import cl.keanzato.app.core.Persona;
import cl.keanzato.app.interfaces.InterfacePersona;

public class PersonaDao implements InterfacePersona {

	public boolean agregar(Persona persona) throws SQLException, ClassNotFoundException {
		try {
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection()
					.prepareStatement("insert into persona values(?,?,?,?,?,?,?)");
			consulta.setInt(1, persona.getRut());
			consulta.setInt(2, persona.getDigitoverificador());
			consulta.setString(3, persona.getNombre());
			consulta.setString(4, persona.getApellidopaterno());
			consulta.setString(5, persona.getApellidomaterno());
			consulta.setString(6, persona.getPais());
			consulta.setString(7, persona.getGenero());

			consulta.executeQuery();

			return true;
		} catch (SQLException ex) {
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean validarRut(String rut) {
		boolean validacion = false;
		try {
			rut = rut.toUpperCase();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

			char dv = rut.charAt(rut.length() - 1);

			int m = 0, s = 1;
			for (; rutAux != 0; rutAux /= 10) {
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
				validacion = true;
			}

		} catch (java.lang.NumberFormatException e) {
		} catch (Exception e) {
		}
		return validacion;
	}

	public List<Persona> lista() throws SQLException, ClassNotFoundException {
		try {
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection().prepareStatement("select * from persona");
			ResultSet rst = consulta.executeQuery();
			List<Persona> personas = new ArrayList<Persona>();

			while (rst.next()) {
				personas.add(parser(rst));
			}
			return personas;
		} catch (SQLException ex) {
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	private Persona parser(ResultSet rst) throws SQLException {
		Persona persona = new Persona();

		persona.setRut(rst.getInt("rut"));
		persona.setDigitoverificador(rst.getInt("digitoverificador"));
		persona.setNombre(rst.getString("nombre"));
		persona.setApellidopaterno(rst.getString("apellidopaterno"));
		persona.setApellidomaterno(rst.getString("apellidomaterno"));
		persona.setPais(rst.getString("pais"));
		persona.setGenero(rst.getString("genero"));

		return persona;
	}
}
