package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VentasConcretadasInterface;
import model.VentaConcretada;
import util.MySQLConexion8;

public class GestionVentasConcretadas implements VentasConcretadasInterface{

	@Override
	public int cantidadVentas(String fech1, String fech2) {
		
	}

	@Override
	public ArrayList<VentaConcretada> buscarVentasEnFechas(String fech1, String fech2, int cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
