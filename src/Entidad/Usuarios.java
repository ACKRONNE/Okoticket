package Entidad;

public class Usuarios {
	private String idUsuario;
	private String rol;
	private String cedula;
	private String nombre;
	private String correo;
	private String contrasena;
	
	
	public Usuarios(){
    	
	 }
	 public Usuarios(String idUsuario,String rol, String cedula, String nombre, String correo, String contrasena) {
		 	this.idUsuario=idUsuario;
		 	this.rol=rol;
	        this.cedula = cedula;
	        this.nombre = nombre;
	        this.correo=correo;
	        this.contrasena=contrasena;
	 }
	 public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	 
}
