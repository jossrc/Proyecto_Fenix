package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.MarcaProductoInterface;
import model.MarcaProducto;
import util.MySQLConexion8;

public class GestionMarcaProducto implements MarcaProductoInterface {

	@Override
	public ArrayList<MarcaProducto> listado() {
		
		ArrayList<MarcaProducto> lista = new ArrayList<MarcaProducto>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "";

			pst = con.prepareStatement(sql);		

			rs = pst.executeQuery();			
			
			while(rs.next()) {	
				
				int id = rs.getInt(1);
				String descripcion = rs.getString(2);
				
				MarcaProducto tipo = new MarcaProducto(id, descripcion);
				
				lista.add(tipo);
			}

		} catch (Exception e) {
			System.out.println("Error en listado (Marcas) " + e.getMessage());
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

