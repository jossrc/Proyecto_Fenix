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
		int cantidad = 0;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_buscarCantidadVentasEnFechas(?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, fech1);
			pst.setString(2, fech2);

			rs = pst.executeQuery();

			if (rs.next()) {						
				cantidad = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Error en obtener la cantidad de Ventas Concretadas: " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return cantidad;
	}

	@Override
	public ArrayList<VentaConcretada> buscarVentasEnFechas(String fech1, String fech2, int cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
