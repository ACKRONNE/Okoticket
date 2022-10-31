package Entidad;


/**

 */
public class Tickets {

    private String idTicket;
    private String rif;
    private String tipoTicket;
    private String fechaSolicitudTicket;
    private String operadorDeRecepcion;
    private String viaRecibido;
    private String fechaCierre;
    private String status;
    private String asunto;
    private String descripcion;
    private String prioridad;

    public Tickets(){
    	
    }
    public Tickets(String idTicket, String rif, String tipoTicket, String fechaSolicitudTicket, String operadorDeRecepcion, String viaRecibido, String fechaCierre, String status, String asunto, String descripcion, String prioridad) {
        this.idTicket = idTicket;
        this.rif = rif;
        this.tipoTicket = tipoTicket;
        this.fechaSolicitudTicket = fechaSolicitudTicket;
        this.operadorDeRecepcion = operadorDeRecepcion;
        this.viaRecibido = viaRecibido;
        this.fechaCierre = fechaCierre;
        this.status = status;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }
	public String getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
	}
	public String getRif() {
		return rif;
	}
	public void setRif(String rif) {
		this.rif = rif;
	}
	public String getTipoTicket() {
		return tipoTicket;
	}
	public void setTipoTicket(String tipoTicket) {
		this.tipoTicket = tipoTicket;
	}
	public String getFechaSolicitudTicket() {
		return fechaSolicitudTicket;
	}
	public void setFechaSolicitudTicket(String fechaSolicitudTicket) {
		this.fechaSolicitudTicket = fechaSolicitudTicket;
	}
	public String getOperadorDeRecepcion() {
		return operadorDeRecepcion;
	}
	public void setOperadorDeRecepcion(String operadorDeRecepcion) {
		this.operadorDeRecepcion = operadorDeRecepcion;
	}
	public String getViaRecibido() {
		return viaRecibido;
	}
	public void setViaRecibido(String viaRecibido) {
		this.viaRecibido = viaRecibido;
	}
	public String getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
    
	

}
