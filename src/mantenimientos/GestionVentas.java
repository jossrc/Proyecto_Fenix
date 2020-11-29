package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import interfaces.VentasInterface;
import model.Boleta;
import model.DetalleBoleta;
import model.Venta;
import util.MySQLConexion8;

public class GestionVentas implements VentasInterface {

	@Override
	public int realizarVentaCompleta(Venta venta, ArrayList<DetalleBoleta> detalle, Boleta boleta) {
		
		int ok = -1;		
		
		
		return ok;
	}
	
	
}
