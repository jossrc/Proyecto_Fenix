package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.BoletaDNIClienteInterface;
import model.BoletaDNICliente;
import util.MySQLConexion8;

public class GestionBoletaDNIClientes implements BoletaDNIClienteInterface {

	@Override
	public ArrayList<BoletaDNICliente> listadoPorBoleta(int boleta) {
		ArrayList<BoletaDNICliente> lista = new ArrayList<BoletaDNICliente>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_listadoBoletaPorNumero(?)}";
			
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, boleta);

			rs = pst.executeQuery();

			while (rs.next()) {				
				int numeroBoleta = rs.getInt(1);
				String dniCliente = rs.getString(2);
				String fecha = rs.getString(3);
				double subtotal = rs.getDouble(4);
				double descuento = rs.getDouble(5);
				double total = rs.getDouble(6);
				
				BoletaDNICliente bol = new BoletaDNICliente(numeroBoleta, dniCliente, fecha, subtotal, descuento, total);
				lista.add(bol);
			}
		} catch (Exception e) {
			System.out.println("Error en Obtener Boleta por numero de Boleta : " + e.getMessage());
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
	public ArrayList<BoletaDNICliente> listadoPorDNI(String dni) {
		ArrayList<BoletaDNICliente> lista = new ArrayList<BoletaDNICliente>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_listadoBoletaPorDNI(?)}";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, dni);

			rs = pst.executeQuery();

			while (rs.next()) {				
				int numeroBoleta = rs.getInt(1);
				String dniCliente = rs.getString(2);
				String fecha = rs.getString(3);
				double subtotal = rs.getDouble(4);
				double descuento = rs.getDouble(5);
				double total = rs.getDouble(6);
				
				BoletaDNICliente bol = new BoletaDNICliente(numeroBoleta, dniCliente, fecha, subtotal, descuento, total);
				lista.add(bol);
			}
		} catch (Exception e) {
			System.out.println("Error en Obtener Boletas por Dni Cliente : " + e.getMessage());
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
	public ArrayList<BoletaDNICliente> listadoPorRangoFechas(String fech1, String fech2) {
		ArrayList<BoletaDNICliente> lista = new ArrayList<BoletaDNICliente>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_listadoBoletaPorRangoFechas(?,?)}";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, fech1);
			pst.setString(2, fech2);

			rs = pst.executeQuery();

			while (rs.next()) {				
				int numeroBoleta = rs.getInt(1);
				String dniCliente = rs.getString(2);
				String fecha = rs.getString(3);
				double subtotal = rs.getDouble(4);
				double descuento = rs.getDouble(5);
				double total = rs.getDouble(6);
				
				BoletaDNICliente bol = new BoletaDNICliente(numeroBoleta, dniCliente, fecha, subtotal, descuento, total);
				lista.add(bol);
			}
		} catch (Exception e) {
			System.out.println("Error en Obtener Boletas por Fechas : " + e.getMessage());
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
