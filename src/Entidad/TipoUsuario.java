package Entidad;

public class TipoUsuario {
	private String idTipoUsuario;
	private String tipoUsuario;
	
	public TipoUsuario(){
    	
    }
    public TipoUsuario(String idTipoUsuario, String tipoUsuario) {
        this.idTipoUsuario = tipoUsuario;
        this.tipoUsuario = tipoUsuario;
    }
	public String getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(String idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
    
	

}
