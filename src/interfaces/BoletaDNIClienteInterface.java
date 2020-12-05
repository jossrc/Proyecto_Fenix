package interfaces;

import java.util.ArrayList;

public interface BoletaDNIClienteInterface {

	public ArrayList<BoletaDNIClienteInterface> listadoPorBoleta(int boleta);
	
	public ArrayList<BoletaDNIClienteInterface> listadoPorDNI(String dni);
	
	public ArrayList<BoletaDNIClienteInterface> listadoPorRangoFechas(String fech1, String fech2);
}
