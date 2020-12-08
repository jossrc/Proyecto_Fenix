package model;

public class MarcaProducto {
	
	private int idMarca;
	private String descripcion;
	
	public MarcaProducto(int idMarca, String descripcion) {		
		this.idMarca = idMarca;
		this.descripcion = descripcion;
	}

	public MarcaProducto() {
		
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
