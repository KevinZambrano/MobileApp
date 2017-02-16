package cl.keanzato.app.core;

public class Usuario {

	private String idusuario;
	private String password;
	private String correo;
	private int rut;
	
	/**
	 * @return the rut
	 */
	public int getRut() {
		return rut;
	}
	/**
	 * @param rut the rut to set
	 */
	public void setRut(int rut) {
		this.rut = rut;
	}
	/**
	 * @return the idusuario
	 */
	public String getIdusuario() {
		return idusuario;
	}
	/**
	 * @param idusuario the idusuario to set
	 */
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @param idusuario
	 * @param password
	 * @param correo
	 */
	public Usuario(String idusuario, String password, String correo, int rut) {
		super();
		this.idusuario = idusuario;
		this.password = password;
		this.correo = correo;
		this.rut = rut;
	}
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	
	
}
