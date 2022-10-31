
package Entidad;

public class Status {
    
    private String idStatus;
    private String status;
    
    public Status(){
    	
    }
    public Status(String idStatus, String status) {
        this.idStatus = idStatus;
        this.status = status;
    }
	public String getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

   
    
}
