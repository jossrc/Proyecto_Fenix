package model;

public class DetalleBoletaProducto {
	
	private int numBoleta;
	private String descripcionProducto;
	private double precioUnitProd;
	private double importe;
	private int cantidadComprada;
	
	public DetalleBoletaProducto(int numBoleta, String descripcionProducto, double precioUnitProd, double importe,
			int cantidadComprada) {
		this.numBoleta = numBoleta;
		this.descripcionProducto = descripcionProducto;
		this.precioUnitProd = precioUnitProd;
		this.importe = importe;
		this.cantidadComprada = cantidadComprada;
	}

	public int getNumBoleta() {
		return numBoleta;
	}

	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
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

	public double getPrecioUnitProd() {
		return precioUnitProd;
	}

	public void setPrecioUnitProd(double precioUnitProd) {
		this.precioUnitProd = precioUnitProd;
	}

}
