package model;

public class DetalleBoleta {

	private int numeroBoleta;
	private String codigoProducto;
	private double importe;
	private int cantidadComprada;
	
	public DetalleBoleta(int numeroBoleta, String codigoProducto, double importe, int cantidadComprada) {
		this.numeroBoleta = numeroBoleta;
		this.codigoProducto = codigoProducto;
		this.importe = importe;
		this.cantidadComprada = cantidadComprada;
	}

	public int getNumeroBoleta() {
		return numeroBoleta;
	}

	public void setNumeroBoleta(int numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}
	
}
