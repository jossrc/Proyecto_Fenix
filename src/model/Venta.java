package model;

public class Venta {

	private int numeroVenta;
	private int idVendedor;
	private int numeroBoleta;
	
	public Venta(int numeroVenta, int idVendedor, int numeroBoleta) {		
		this.numeroVenta = numeroVenta;
		this.idVendedor = idVendedor;
		this.numeroBoleta = numeroBoleta;
	}

	public int getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public int getNumeroBoleta() {
		return numeroBoleta;
	}

	public void setNumeroBoleta(int numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}
	
}
