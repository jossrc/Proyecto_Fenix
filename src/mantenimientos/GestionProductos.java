package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Producto;
import util.MySQLConexion8;

public class GestionProductos implements ProductoInterface {
	
	@Override
	public String generarCodigo() {
		String codigo = "PROD0001";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_generarCodigoProducto()}";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				DecimalFormat df = new DecimalFormat("0000");
				codigo = "PROD" + df.format(Integer.parseInt(rs.getString(1)) + 1);
			}
			
		} catch (Exception e) {
			System.out.println("Error en generar codigo Producto : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return codigo;
	}

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
	public int eliminar(String codigoProducto) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "UPDATE PRODUCTO SET ESTADO = 0 WHERE COD_PRO = ?";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigoProducto);

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
	public Producto buscar(String codProducto) {
		Producto p = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM PRODUCTO WHERE COD_PRO = ? AND ESTADO = 1";
			pst = con.prepareStatement(sql);

			pst.setString(1, codProducto);

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
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM PRODUCTO WHERE ESTADO = 1";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				String codigo = rs.getString(1);
				String descripcion = rs.getString(2);
				int idMarca = rs.getInt(3);
				int idTipo = rs.getInt(4);
				int stock = rs.getInt(5);
				double precioUnitario = rs.getDouble(6);
				int estado = rs.getInt(7);

				Producto producto = new Producto(codigo, descripcion, idMarca, idTipo, stock, precioUnitario, estado);
				lista.add(producto);
			}
		} catch (Exception e) {
			System.out.println("Error en listado Producto : " + e.getMessage());
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
	public int aplicarDescuentoXProducto(String codigo, int tipoDesc, double descuento) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_aplicarDescuentoProducto(?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);
			pst.setInt(2, tipoDesc);
			pst.setDouble(3, descuento);
			
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en aplicar descuento por producto: " + e.getMessage());
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
	public int aplicarDescuentoXTipo(int tipoDesc, int tipoProd, double descuento) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_aplicarDescuentoProductoXTipo(?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setInt(1, tipoDesc);
			pst.setInt(2, tipoProd);
			pst.setDouble(3, descuento);
			
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en aplicar descuento por tipo: " + e.getMessage());
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
	public int aplicarDescuentoXMarca(int tipoDesc, int tipoMarc, double descuento) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_aplicarDescuentoProductoXMarca(?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setInt(1, tipoDesc);
			pst.setInt(2, tipoMarc);
			pst.setDouble(3, descuento);
			
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en aplicar descuento por tipo: " + e.getMessage());
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
	public int aplicarDescuentoATodos(int tipoDesc, double descuento) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_aplicarDescuentoProductoTodos(?,?)}";
			pst = con.prepareStatement(sql);

			pst.setInt(1, tipoDesc);
			pst.setDouble(2, descuento);
			
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en aplicar descuento por tipo: " + e.getMessage());
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
	public double obtenerPrecioMinimo() {
		double precioMinimo = -1;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT MIN(PREC_UNIT_PRO) FROM PRODUCTO;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			if (rs.next()) {						
				precioMinimo = rs.getDouble(1);
			}
			
		} catch (Exception e) {
			System.out.println("Error en obtener el precio minimo de un producto " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return precioMinimo;
	}
}
