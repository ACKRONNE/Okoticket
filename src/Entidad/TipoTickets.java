package Entidad;

public class TipoTickets {

		private String idTipo;
		private String requerimiento;
		
		public TipoTickets(){
	    	
		 }
		 public TipoTickets(String idTipo, String requerimiento) {
		        this.idTipo = idTipo;
		        this.requerimiento = requerimiento;
		 }
		public String getIdTipo() {
			return idTipo;
		}
		public void setIdTipo(String idTipo) {
			this.idTipo = idTipo;
		}
		public String getRequerimiento() {
			return requerimiento;
		}
		public void setRequerimiento(String requerimiento) {
			this.requerimiento = requerimiento;
		}
		 
		 
}
