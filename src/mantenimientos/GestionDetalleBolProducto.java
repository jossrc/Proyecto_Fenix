package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DetalleBoletaProductoInterface;
import model.DetalleBoletaProducto;

import util.MySQLConexion8;

public class GestionDetalleBolProducto implements DetalleBoletaProductoInterface {

	@Override
	public ArrayList<DetalleBoletaProducto> listaDetalle(int numBol) {
		
		ArrayList<DetalleBoletaProducto> lista = new ArrayList<DetalleBoletaProducto>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_listaDetalleBolProd(?)}";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1,numBol);

			rs = pst.executeQuery();

			while (rs.next()) {				
				
				int numBoleta = rs.getInt(1);
				String descripcionProducto = rs.getString(2);
				double importe = rs.getDouble(3);
				int cantidadComprada = rs.getInt(4);

				DetalleBoletaProducto det = new DetalleBoletaProducto(numBoleta, descripcionProducto, importe, cantidadComprada);
				lista.add(det);
			}
		} catch (Exception e) {
			System.out.println("Error en listado Producto : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return lista;
	}

}
