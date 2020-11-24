package mantenimientos;

import java.util.ArrayList;

import interfaces.ClientesInterface;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.MySQLConexion8;

public class GestionClientes implements ClientesInterface {

	@Override
	public int registrar(Cliente cliente) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "insert into CLIENTE values (null, ?, ?, ?, ?, ?, ?)";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, cliente.getDni_cli());
			pst.setString(2, cliente.getNom_cli());
			pst.setString(3, cliente.getApe_cli());
			pst.setString(4, cliente.getDirec_cli());
			pst.setString(5, cliente.getTelef_cli());
			pst.setInt(6, cliente.getEstado_cli());
			
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en registrar : " + e.getMessage());
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
	public int eliminar(String dni) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "UPDATE CLIENTE SET ESTADO = 0 WHERE DNI_CLI = ?";
			pst = con.prepareStatement(sql);

			pst.setString(1, dni);

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en Eliminar : " + e.getMessage());
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
	/* Corresponde a Editar el CRUD */
	public int actualizar(Cliente cliente) {
		int rs = 0; // returns result of operation
		// Database format
		Connection con = null; // for connecting
		PreparedStatement pst = null; // for sentencing
		try {
			// 1. obtain connection with DB
			con = MySQLConexion8.getConexion();
			// 2.Create sentence to be used
			String sql = "update CLIENTE set DNI_CLI = ?, NOM_CLI = ?, APE_CLI = ?, DIREC_CLI = ?, TELEF_CLI = ?, ESTADO = ? WHERE ID_CLI = ?";
			// 3. Prepare sentence to be executed
			pst = con.prepareStatement(sql);
			// set the strings

			pst.setString(1, cliente.getDni_cli());
			pst.setString(2, cliente.getNom_cli());
			pst.setString(3, cliente.getApe_cli());
			pst.setString(4, cliente.getDirec_cli());
			pst.setString(5, cliente.getTelef_cli());
			pst.setInt(6, cliente.getEstado_cli());
			pst.setInt(7, cliente.getId_cli());
			// 4. Execute the sentence and save the result
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar cliente : " + e.getMessage());
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
	public Cliente buscar(String dni) {
		Cliente cliente = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM CLIENTE WHERE DNI_CLI = ? AND ESTADO = 1";
			pst = con.prepareStatement(sql);

			pst.setString(1, dni);

			rs = pst.executeQuery();

			if (rs.next()) {

				String dni_cli = rs.getString(1);
				String nom = rs.getString(2);
				String ape = rs.getString(3);
				String dir = rs.getString(4);
				String tel = rs.getString(5);
				int estado = rs.getInt(6);
				int id = rs.getInt(7);

				cliente = new Cliente(id, dni_cli, nom, ape, dir, tel, estado);

			}
		} catch (Exception e) {
			System.out.println("Error en buscar Cliente : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return cliente;
	}

	@Override
	public ArrayList<Cliente> listado() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM CLIENTE WHERE ESTADO = 1";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String dni_cli = rs.getString(2);
				String nom = rs.getString(3);
				String ape = rs.getString(4);
				String dir = rs.getString(5);
				String tel = rs.getString(6);
				int estado = rs.getInt(7);

				Cliente cliente = new Cliente(id, dni_cli, nom, ape, dir, tel, estado);
				lista.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("Error en listado Cliente : " + e.getMessage());
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
