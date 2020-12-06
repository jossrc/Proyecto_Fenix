package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.BoletaInterface;
import model.Boleta;
import util.MySQLConexion8;

public class GestionBoleta implements BoletaInterface {

	@Override
	public Boleta buscarPorNumero(int numBol) {
		Boleta b = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "";
			pst = con.prepareStatement(sql);

			pst.setInt(1, numBol);

			rs = pst.executeQuery();

			if (rs.next()) {
								
				int numeroBoleta = rs.getInt(1);
				String fecha = rs.getString(2);
				double subtotal = rs.getDouble(3);
				double descuento = rs.getDouble(4);
				double total = rs.getDouble(5);
				int idCliente = rs.getInt(6);
				
				b = new Boleta(numeroBoleta, fecha, subtotal, descuento, total, idCliente);
			}
		} catch (Exception e) {
			System.out.println("Error en buscar Boleta : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return b;
	}

}
