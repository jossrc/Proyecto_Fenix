package model;

public class ReporteProducto {

	private String codigo;
	private String descripcion;
	private String marca;
	private String tipo;
	private int stock;
	private double precio;

	public ReporteProducto(String codigo, String descripcion, String marca, String tipo, int stock, double precio) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.tipo = tipo;
		this.stock = stock;
		this.precio = precio;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
