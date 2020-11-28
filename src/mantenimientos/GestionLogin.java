package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.LoginInterface;
import model.Login;
import model.Vendedor;
import util.MySQLConexion8;

public class GestionLogin implements LoginInterface{

	@Override
	public Login iniciarSesion(String username, String clave) {
		Login login = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM LOGIN WHERE USERNAME = ? AND CLAVE = ?";
			pst = con.prepareStatement(sql);

			pst.setString(1, username);
			pst.setString(2, clave);

			rs = pst.executeQuery();

			if (rs.next()) {

				String usuario = rs.getString(1);
				String pass = rs.getString(2);				
				int idVendedor = rs.getInt(3);

				login = new Login(usuario, pass, idVendedor);

			}
		} catch (Exception e) {
			System.out.println("Error al tratar de Iniciar Sesión : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return login;
	}

	@Override
	public Vendedor obtenerVendedorYLogueo(int idVend) {
		Vendedor vendedor= null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{CALL usp_obtenerVendedorYLogueo(?)}";
			pst = con.prepareStatement(sql);

			pst.setInt(1, idVend);

			rs = pst.executeQuery();

			if (rs.next()) {

				int id = rs.getInt(1);
				String dniVend = rs.getString(2);
				String nombre = rs.getString(3);
				String apellido = rs.getString(4);
				String direccion = rs.getString(5);
				String telefono = rs.getString(6);
				int estado = rs.getInt(7);
				int tipo = rs.getInt(8);

				vendedor = new Vendedor(id, dniVend, nombre, apellido, direccion, telefono, estado, tipo);

			}
		} catch (Exception e) {
			System.out.println("Error en Cargar Información del Vendedor (Login): " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return vendedor;
	}

}
