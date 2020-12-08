package interfaces;

import java.util.ArrayList;

import model.VentaConcretada;

public interface VentasConcretadasInterface {

	public int cantidadVentas(String fech1, String fech2);
	
	public ArrayList<VentaConcretada> buscarVentasEnFechas(String fech1, String fech2, int cantidad);
	
	public int obtenerHistorialVentas();
	
	public double obtenerHistorialGanancia();
	
}
