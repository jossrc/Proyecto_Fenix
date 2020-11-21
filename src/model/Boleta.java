package model;

public class Boleta {
  
	private int numeroBoleta;
	private String fecha;
	private double subtotal;
	private double descuento = 0;
	private double total;
	private int idCliente;
	
	public Boleta(int numeroBoleta, String fecha, double subtotal, double descuento, double total, int idCliente) {		
		this.numeroBoleta = numeroBoleta;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.total = total;
		this.idCliente = idCliente;
	}

	public int getNumeroBoleta() {
		return numeroBoleta;
	}

	public void setNumeroBoleta(int numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

}
