package interfaces;

import java.util.ArrayList;

import model.Boleta;
import model.DetalleBoleta;
import model.Venta;

public interface VentasInterface {
	
	public int obtenerNumBoleta();

	public int realizarVentaCompleta(Venta venta, ArrayList<DetalleBoleta> detalle, Boleta boleta);
	
}
