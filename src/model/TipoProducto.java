package model;

public class TipoProducto {
	
		private int idTipo;
		private String descripcion;		
		
		public TipoProducto(int idTipo, String descripcion) {
			
			this.idTipo = idTipo;
			this.descripcion = descripcion;
		}

		public TipoProducto() {
			
		}

		public int getIdTipo() {
			return idTipo;
		}

		public void setIdTipo(int idTipo) {
			this.idTipo = idTipo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

}
