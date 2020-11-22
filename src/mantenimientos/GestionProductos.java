package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Producto;
import util.MySQLConexion8;

public class GestionProductos implements ProductoInterface {

	@Override
	public int registrar(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "INSERT INTO PRODUCTO VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, p.getCodigo());
			pst.setString(2, p.getDescripcion());
			pst.setInt(3, p.getIdMarca());
			pst.setInt(4, p.getIdTipo());
			pst.setInt(5, p.getStock());
			pst.setDouble(6, p.getPrecioUnitario());
			pst.setInt(7, p.getEstado());
			
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en registrar Producto : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminar(int codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Producto p) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_actualizarProducto(?,?,?,?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, p.getCodigo());
			pst.setString(2, p.getDescripcion());
			pst.setInt(3, p.getIdMarca());
			pst.setInt(4, p.getIdTipo());			
			pst.setInt(5, p.getStock());
			pst.setDouble(6, p.getPrecioUnitario());
			
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en actualizar Producto: " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public Producto buscar(int codProducto) {
		Producto p = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM PRODUCTO WHERE COD_PRO = ?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, codProducto);

			rs = pst.executeQuery();

			if (rs.next()) {
								
				String codigo = rs.getString(1);
				String descripcion = rs.getString(2);
				int idMarca = rs.getInt(3);
				int idTipo = rs.getInt(4);
				int stock = rs.getInt(5);
				double precioUnitario = rs.getDouble(6);
				int estado = rs.getInt(7);
				
				p = new Producto(codigo, descripcion, idMarca, idTipo, stock, precioUnitario, estado);

			}
		} catch (Exception e) {
			System.out.println("Error en buscar Producto : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return p;
	}

	@Override
	public ArrayList<Producto> listado() {
		// TODO Auto-generated method stub
		return null;
	}

}
