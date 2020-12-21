package model;

public class ProductoXMarcaTipo {

	private String codigo;
	private String descripcion;
	private String marca;
	private String tipo;
	private int stock;
	private double precioUnit;
	
	public ProductoXMarcaTipo(String codigo, String descripcion, String marca, String tipo, int stock,
			double precioUnit) {		
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.tipo = tipo;
		this.stock = stock;
		this.precioUnit = precioUnit;
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

	public double getPrecioUnit() {
		return precioUnit;
	}

	public void setPrecioUnit(double precioUnit) {
		this.precioUnit = precioUnit;
	}

}
