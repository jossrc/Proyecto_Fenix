package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VendedorInterface;
import model.Vendedor;
import util.MySQLConexion8;

public class GestionVendedores implements VendedorInterface {

	@Override
	public int registrar(Vendedor vendedor) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "INSERT INTO VENDEDOR VALUES (null, ?, ?, ?, ?, ?, ?)";

			pst = con.prepareStatement(sql);

			pst.setString(1, vendedor.getDni());
			pst.setString(2, vendedor.getNombre());
			pst.setString(3, vendedor.getApellido());
			pst.setString(4, vendedor.getDireccion());
			pst.setString(5, vendedor.getTelefono());
			pst.setInt(6, vendedor.getEstado());
			
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en registrar vendedor : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rs;
	}

	@Override
	public int actualizar(Vendedor vendedor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vendedor buscar(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminar(String dni) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Vendedor> listado() {
		// TODO Auto-generated method stub
		return null;
	}

}
