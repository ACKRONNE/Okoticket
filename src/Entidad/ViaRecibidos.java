package Entidad;

public class ViaRecibidos {
	private String idVia;
	private String viaRecibido;

public ViaRecibidos(){
	
}
public ViaRecibidos(String idVia, String viaRecibido) {
	 	this.idVia=idVia;
        this.viaRecibido = viaRecibido;
       
}
public String getIdVia() {
	return idVia;
}
public void setIdVia(String idVia) {
	this.idVia = idVia;
}
public String getViaRecibido() {
	return viaRecibido;
}
public void setViaRecibido(String viaRecibido) {
	this.viaRecibido = viaRecibido;
}

}