package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public int actualizar(Producto producto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Producto buscar(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Producto> listado() {
		// TODO Auto-generated method stub
		return null;
	}

}
