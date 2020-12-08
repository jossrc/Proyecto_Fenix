package model;

public class VentaConcretada {
	
	private int numBoleta;
	private String cliente;
	private int comprasRealizadas;
	private double total;
	
	public VentaConcretada(int numBoleta, String cliente, int comprasRealizadas, double total) {
		this.numBoleta = numBoleta;
		this.cliente = cliente;
		this.comprasRealizadas = comprasRealizadas;
		this.total = total;
	}

	public int getNumBoleta() {
		return numBoleta;
	}

	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getComprasRealizadas() {
		return comprasRealizadas;
	}

	public void setComprasRealizadas(int comprasRealizadas) {
		this.comprasRealizadas = comprasRealizadas;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
