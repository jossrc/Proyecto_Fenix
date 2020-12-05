package model;

public class BoletaDNICliente {

	private int numeroBoleta;
	private String dniCliente;
	private String fecha;
	private double subtotal;
	private double descuento;
	private double total;
	
	public BoletaDNICliente(int numeroBoleta, String dniCliente, String fecha, double subtotal, double descuento,
			double total) {
		this.numeroBoleta = numeroBoleta;
		this.dniCliente = dniCliente;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.total = total;
	}

	public int getNumeroBoleta() {
		return numeroBoleta;
	}

	public void setNumeroBoleta(int numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
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

}
