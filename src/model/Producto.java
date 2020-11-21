package model;

public class Producto {

	private String codigo;
	private String descripcion;
	private int idMarca;
	private int idTipo;
	private int stock;
	private double precioUnitario;
	private int estado = 1;
	
	public Producto(String codigo, String descripcion, int idMarca, int idTipo, int stock, double precioUnitario) {		
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.idMarca = idMarca;
		this.idTipo = idTipo;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
	}

	public Producto(String codigo, String descripcion, int idMarca, int idTipo, int stock, double precioUnitario,
			int estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.idMarca = idMarca;
		this.idTipo = idTipo;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
