package Entidad;

public class Clientes {
	private String idClientes;
	private String rif;
	private String nombreEmpresa;
	private String contacto;
	private String direccion;

	public Clientes(){
	    	
	 }
	public Clientes(String idClientes, String rif, String nombreEmpresa, String contacto, String direccion) {
	        this.idClientes=idClientes;
			this.rif = rif;
	        this.nombreEmpresa = nombreEmpresa;
	        this.contacto= contacto;
	        this.direccion= direccion;
	 }
	public String getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(String idClientes) {
		this.idClientes = idClientes;
	}
	public String getRif() {
		return rif;
	}
	public void setRif(String rif) {
		this.rif = rif;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
 