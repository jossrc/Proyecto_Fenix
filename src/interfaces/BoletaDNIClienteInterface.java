package interfaces;

import java.util.ArrayList;

import model.BoletaDNICliente;

public interface BoletaDNIClienteInterface {

	public ArrayList<BoletaDNICliente> listadoPorBoleta(int boleta);
	
	public ArrayList<BoletaDNICliente> listadoPorDNI(String dni);
	
	public ArrayList<BoletaDNICliente> listadoPorRangoFechas(String fech1, String fech2);
}
