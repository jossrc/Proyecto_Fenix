package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.ProductoXMarcaTipoInterface;
import model.ProductoXMarcaTipo;
import util.MySQLConexion8;

public class GestionProductoXMarcaTipo implements ProductoXMarcaTipoInterface {

	@Override
	public ProductoXMarcaTipo buscarProductoMarcaTipo(String codProducto) {
		ProductoXMarcaTipo p = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "call usp_buscarProductoTipoMarca(?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, codProducto);

			rs = pst.executeQuery();

			if (rs.next()) {
								
				String codigo = rs.getString(1);
				String descripcion = rs.getString(2);
				String marca = rs.getString(3);
				String tipo = rs.getString(4);
				int stock = rs.getInt(5);
				double precioUnit = rs.getDouble(6);
				
				p = new ProductoXMarcaTipo(codigo, descripcion, marca, tipo, stock, precioUnit);

			}
		} catch (Exception e) {
			System.out.println("Error en buscar Producto con Marca Tipo: " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return p;
	}

}
