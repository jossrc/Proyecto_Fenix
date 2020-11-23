package model;

public class ReporteProducto {
	
	private String cod;
	private String desc;
	private String marca;
	private String tipo;
	private int stock;
	private double precio;
	
	
	
	public ReporteProducto(String cod, String desc, String marca, String tipo, int stock, double precio) {
		super();
		this.cod = cod;
		this.desc = desc;
		this.marca = marca;
		this.tipo = tipo;
		this.stock = stock;
		this.precio = precio;
	}
	
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
