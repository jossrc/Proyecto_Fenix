package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ReporteProductoInterface;

import model.ReporteProducto;
import util.MySQLConexion8;

public class GestionReporteProducto implements ReporteProductoInterface{

	@Override
	public ArrayList<ReporteProducto> listado() {

		ArrayList<ReporteProducto> lista = new ArrayList<ReporteProducto>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_ReporteProductoListado()}";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {			
				
				String codigo = rs.getString(1);
				String desc = rs.getString(2);
				String marca = rs.getString(3);
				String tipo = rs.getString(4);
				int stock = rs.getInt(5);
				double precio = rs.getDouble(6);

				ReporteProducto reporte = new ReporteProducto(codigo, desc, marca, tipo, stock, precio);
				lista.add(reporte);
			}
		} catch (Exception e) {
			System.out.println("Error en listado : " + e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}

				if (pst != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return lista;
	}

	@Override
	public ArrayList<ReporteProducto> listadoxmarca(int codMarca) {
		ArrayList<ReporteProducto> lista = new ArrayList<ReporteProducto>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_ReporteProductoXMarca(?)}";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, codMarca);

			rs = pst.executeQuery();

			while (rs.next()) {			
				
				String codigo = rs.getString(1);
				String descripcion = rs.getString(2);
				String marca = rs.getString(3);
				String tipo = rs.getString(4);
				int stock = rs.getInt(5);
				double precio = rs.getDouble(6);

				ReporteProducto rep = new ReporteProducto(codigo, descripcion, marca, tipo, stock, precio);
				lista.add(rep);
			}
		} catch (Exception e) {
			System.out.println("Error en listado x Marca : " + e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}

				if (pst != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return lista;
	}

	@Override
	public ArrayList<ReporteProducto> listadoxtipo(int codTipo) {
		ArrayList<ReporteProducto> lista = new ArrayList<ReporteProducto>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_ReporteProductoXTipo(?)}";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, codTipo);

			rs = pst.executeQuery();

			while (rs.next()) {			
				
				String codigo = rs.getString(1);
				String descripcion = rs.getString(2);
				String marca = rs.getString(3);
				String tipo = rs.getString(4);
				int stock = rs.getInt(5);
				double precio = rs.getDouble(6);

				ReporteProducto rep = new ReporteProducto(codigo, descripcion, marca, tipo, stock, precio);
				lista.add(rep);
			}
		} catch (Exception e) {
			System.out.println("Error en listado x Tipo : " + e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}

				if (pst != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return lista;
	}

	@Override
	public ArrayList<ReporteProducto> listadoxstock(int stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReporteProducto> listadoxprecio(double precio) {
		// TODO Auto-generated method stub
		return null;
	}

}
