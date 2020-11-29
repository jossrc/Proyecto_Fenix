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
		
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		PreparedStatement pst4 = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			con.setAutoCommit(false);
			
			// Preparando la boleta
			
			String sql1 = "INSERT INTO BOLETA VALUES (?, ?, ?, ?, ?, ? )";
			pst1 = con.prepareStatement(sql1);
			
			pst1.setInt(1, boleta.getNumeroBoleta());
			pst1.setString(1, boleta.getFecha());
			pst1.setDouble(2, boleta.getSubtotal());
			pst1.setDouble(3, boleta.getDescuento());
			pst1.setDouble(4, boleta.getTotal());
			pst1.setInt(5, boleta.getIdCliente());
			
			ok = pst1.executeUpdate();
			
			// Registrando el detalle

			String sql2 = "INSERT INTO DETALLE_BOLETA VALUES (?,?,?,?)";

			for (DetalleBoleta d : detalle) {
				pst2 = con.prepareStatement(sql2);
				
				pst2.setInt(1, boleta.getNumeroBoleta());
				pst2.setString(2, d.getCodigoProducto());
				pst2.setDouble(3, d.getImporte());
				pst2.setInt(4, d.getCantidadComprada());
				
				ok = pst2.executeUpdate();
			}
			
			// Confirmando la venta

			String sql3 = "INSERT INTO VENTA VALUES (null, ?,?)";
			pst3 = con.prepareStatement(sql3);
			
			pst3.setInt(1, venta.getIdVendedor());
			pst3.setInt(2, boleta.getNumeroBoleta());
			
			ok = pst3.executeUpdate();
			
			// Realizando compra de productos
			
			String sql4 = "{call usp_compraProducto(?,?)}";			
			
			for (DetalleBoleta d : detalle) {
				pst4 = con.prepareStatement(sql4);
				
				pst4.setInt(1, d.getCantidadComprada());
				pst4.setString(2, d.getCodigoProducto());
				
				ok = pst4.executeUpdate();
			}
			
			con.commit();			
			
		} catch (Exception e) {
			System.out.println("Error al efectuar la venta : " + e.getMessage());
			ok = -1;
			
			try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("Error al restaurar : " + e.getMessage());
			}			
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e3) {
				System.out.println("Error al cerrar: " + e3.getMessage());
			}
		}
		
		return ok;
	}
	
	
}
