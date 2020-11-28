package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

			String sql = "INSERT INTO VENDEDOR VALUES (null, ?, ?, ?, ?, ?, ?, 1)";

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
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "{usp_actualizarVendedor(?,?,?,?,?,?)}";
			
			pst = con.prepareStatement(sql);

			pst.setString(1, vendedor.getDni());
			pst.setString(2, vendedor.getNombre());
			pst.setString(3, vendedor.getApellido());
			pst.setString(4, vendedor.getDireccion());
			pst.setString(5, vendedor.getTelefono());
			pst.setInt(6, vendedor.getEstado());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar Vendedor : " + e.getMessage());
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
	public Vendedor buscar(String dni) {
		Vendedor vendedor= null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM VENDEDOR WHERE DNI_VEND = ? AND ESTADO = 1 AND TIPO = 1";
			pst = con.prepareStatement(sql);

			pst.setString(1, dni);

			rs = pst.executeQuery();

			if (rs.next()) {

				int id = rs.getInt(1);
				String dniVend = rs.getString(2);
				String nombre = rs.getString(3);
				String apellido = rs.getString(4);
				String direccion = rs.getString(5);
				String telefono = rs.getString(6);
				int estado = rs.getInt(7);

				vendedor = new Vendedor(id, dniVend, nombre, apellido, direccion, telefono, estado);

			}
		} catch (Exception e) {
			System.out.println("Error en buscar Vendedor : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return vendedor;
	}

	@Override
	public int eliminar(String dni) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "UPDATE VENDEDOR SET ESTADO = 0 WHERE DNI_VEND = ? AND TIPO = 1";
			pst = con.prepareStatement(sql);

			pst.setString(1, dni);

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en Eliminar Vendedor: " + e.getMessage());
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
	public ArrayList<Vendedor> listado() {
		ArrayList<Vendedor> lista = new ArrayList<Vendedor>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM VENDEDOR WHERE ESTADO = 1 AND TIPO = 1";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String dni = rs.getString(2);
				String nombre = rs.getString(3);
				String apellido = rs.getString(4);
				String direccion = rs.getString(5);
				String telefono = rs.getString(6);
				int estado = rs.getInt(7);

				Vendedor vendedor = new Vendedor(id, dni, nombre, apellido, direccion, telefono, estado);
				lista.add(vendedor);
			}
		} catch (Exception e) {
			System.out.println("Error en listado Vendedores : " + e.getMessage());
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
