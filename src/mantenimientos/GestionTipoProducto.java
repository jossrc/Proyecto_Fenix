package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.TipoProductoInterface;
import model.TipoProducto;
import util.MySQLConexion8;

public class GestionTipoProducto implements TipoProductoInterface {

	@Override
	public ArrayList<TipoProducto> listado() {
		
		ArrayList<TipoProducto> lista = new ArrayList<TipoProducto>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM TIPO_PRODUCTO";

			pst = con.prepareStatement(sql);		

			rs = pst.executeQuery();			
			
			while(rs.next()) {	
				
				int id = rs.getInt(1);
				String descripcion = rs.getString(2);
				
				TipoProducto tipo = new TipoProducto(id, descripcion);
				
				lista.add(tipo);
			}

		} catch (Exception e) {
			System.out.println("Error en listado (Tipos) " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		
		return lista;
	}

	@Override
	public TipoProducto buscarTipo(int num) {
		TipoProducto tp = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM TIPO_PRODUCTO WHERE ID_TIPO_PRO = ?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, num);

			rs = pst.executeQuery();

			if (rs.next()) {
								
				int id =  rs.getInt(1);
				String descripcion = rs.getString(2);
				
				tp = new TipoProducto(id, descripcion);

			}
		} catch (Exception e) {
			System.out.println("Error en mostrar Tipo Producto : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return tp;
	}

}
