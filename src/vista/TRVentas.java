package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class TRVentas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtCliente;
	private JTextField txtBoleta;
	private JTextField txtCodigo;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JTextField txtDescripcionProducto;
	private JTextField txtStock;
	private JTable tblVenta;
	
	private DefaultTableModel model;
	private JTextField txtPagaCon;
	private JTextField txtCambio;
	private JTextField txtSubtotal;
	private JTextField txtDescuento;
	private JTextField txtTotalAPagar;
	private JDateChooser txtFecha;

	public TRVentas() {
		setLayout(null);
		
		JPanel panelVentas = new JPanel();
		panelVentas.setBounds(0, 0, 817, 551);
		add(panelVentas);
		panelVentas.setLayout(null);		
		
		JPanel pDatosVenta = new JPanel();
		pDatosVenta.setBorder(crearBordeTitulo("Datos de venta"));
		pDatosVenta.setBounds(10, 11, 627, 79);
		panelVentas.add(pDatosVenta);
		pDatosVenta.setLayout(null);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(21, 19, 46, 14);
		pDatosVenta.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setBounds(21, 44, 219, 20);
		pDatosVenta.add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblDocumento = new JLabel("DOCUMENTO");
		lblDocumento.setBounds(313, 19, 64, 14);
		pDatosVenta.add(lblDocumento);
		
		txtBoleta = new JTextField();
		txtBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoleta.setText("BOLETA");
		txtBoleta.setEditable(false);
		txtBoleta.setBounds(313, 44, 119, 20);
		pDatosVenta.add(txtBoleta);
		txtBoleta.setColumns(10);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(474, 19, 33, 14);
		pDatosVenta.add(lblFecha);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(467, 44, 128, 20);
		pDatosVenta.add(txtFecha);
		
		JButton btnBuscarCliente = new JButton("");
		btnBuscarCliente.setBounds(250, 44, 26, 20);
		pDatosVenta.add(btnBuscarCliente);
		
		JPanel pDatosProducto = new JPanel();
		pDatosProducto.setBorder(crearBordeTitulo("Datos del Producto"));
		pDatosProducto.setBounds(10, 115, 627, 132);
		panelVentas.add(pDatosProducto);
		pDatosProducto.setLayout(null);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(22, 19, 41, 14);
		pDatosProducto.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(21, 44, 219, 20);
		pDatosProducto.add(txtCodigo);
		
		JButton btnBuscarProducto = new JButton("");
		btnBuscarProducto.setBounds(250, 44, 26, 20);
		pDatosProducto.add(btnBuscarProducto);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setBounds(317, 19, 52, 14);
		pDatosProducto.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(317, 44, 115, 20);
		pDatosProducto.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(479, 19, 38, 14);
		pDatosProducto.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(473, 44, 115, 20);
		pDatosProducto.add(txtPrecio);
		
		JLabel lblDescripcionProducto = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcionProducto.setBounds(22, 75, 69, 14);
		pDatosProducto.add(lblDescripcionProducto);
		
		txtDescripcionProducto = new JTextField();
		txtDescripcionProducto.setEditable(false);
		txtDescripcionProducto.setBounds(22, 100, 218, 20);
		pDatosProducto.add(txtDescripcionProducto);
		txtDescripcionProducto.setColumns(10);
		
		JLabel lblStock = new JLabel("STOCK");
		lblStock.setBounds(483, 75, 33, 14);
		pDatosProducto.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setColumns(10);
		txtStock.setBounds(473, 100, 115, 20);
		pDatosProducto.add(txtStock);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 264, 683, 195);
		panelVentas.add(scrollPane);
		
		tblVenta = new JTable();		
		model = new DefaultTableModel();
		tblVenta.setModel(model);
		scrollPane.setViewportView(tblVenta);
		
		JButton btnAdicionarProducto = new JButton("+");
		btnAdicionarProducto.setBounds(647, 125, 57, 36);
		panelVentas.add(btnAdicionarProducto);
		
		JButton btnQuitarProducto = new JButton("-");
		btnQuitarProducto.setBounds(647, 182, 57, 36);
		panelVentas.add(btnQuitarProducto);
		
		JButton btnGenerarVenta = new JButton("GENERAR");
		btnGenerarVenta.setBounds(703, 296, 102, 36);
		panelVentas.add(btnGenerarVenta);
		
		JButton btnCancelarVenta = new JButton("CANCELAR");
		btnCancelarVenta.setBounds(703, 355, 102, 36);
		panelVentas.add(btnCancelarVenta);
		
		JPanel pCambio = new JPanel();
		pCambio.setBorder(new LineBorder(new Color(0, 0, 0)));
		pCambio.setBounds(10, 470, 305, 70);
		panelVentas.add(pCambio);
		pCambio.setLayout(null);
		
		JLabel lblPagaCon = new JLabel("PAGA CON");
		lblPagaCon.setBounds(10, 11, 52, 14);
		pCambio.add(lblPagaCon);
		
		JLabel lblCambio = new JLabel("CAMBIO");
		lblCambio.setBounds(109, 11, 40, 14);
		pCambio.add(lblCambio);
		
		JButton btnCalcularCambio = new JButton("Calcular");
		btnCalcularCambio.setBounds(214, 21, 77, 37);
		pCambio.add(btnCalcularCambio);
		
		txtPagaCon = new JTextField();
		txtPagaCon.setBounds(10, 36, 86, 20);
		pCambio.add(txtPagaCon);
		txtPagaCon.setColumns(10);
		
		txtCambio = new JTextField();
		txtCambio.setEditable(false);
		txtCambio.setColumns(10);
		txtCambio.setBounds(109, 36, 86, 20);
		pCambio.add(txtCambio);
		
		JPanel pPagar = new JPanel();
		pPagar.setLayout(null);
		pPagar.setBorder(new LineBorder(new Color(0, 0, 0)));
		pPagar.setBounds(332, 470, 456, 70);
		panelVentas.add(pPagar);
		
		JLabel lblSubtotal = new JLabel("SUBTOTAL");
		lblSubtotal.setBounds(10, 11, 51, 14);
		pPagar.add(lblSubtotal);
		
		JLabel lblDescuento = new JLabel("DESCUENTO");
		lblDescuento.setBounds(109, 11, 60, 14);
		pPagar.add(lblDescuento);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setEditable(false);
		txtSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSubtotal.setColumns(10);
		txtSubtotal.setBounds(10, 36, 86, 20);
		pPagar.add(txtSubtotal);
		
		txtDescuento = new JTextField();
		txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDescuento.setText("0.0");
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(109, 36, 86, 20);
		pPagar.add(txtDescuento);
		
		JLabel lblTotalAPagar = new JLabel("TOTAL A PAGAR");
		lblTotalAPagar.setBounds(212, 11, 79, 14);
		pPagar.add(lblTotalAPagar);
		
		txtTotalAPagar = new JTextField();
		txtTotalAPagar.setEditable(false);
		txtTotalAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalAPagar.setColumns(10);
		txtTotalAPagar.setBounds(212, 36, 125, 20);
		pPagar.add(txtTotalAPagar);
		
		JButton btnCalcularPagoTotal = new JButton("Calcular");
		btnCalcularPagoTotal.setBounds(357, 23, 89, 35);
		pPagar.add(btnCalcularPagoTotal);
		model.addColumn("C\u00F3digo");
		model.addColumn("Tipo");
		model.addColumn("Descripci\u00F3n");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		model.addColumn("Importe");
		tblVenta.getColumnModel().getColumn(0).setPreferredWidth(113);
		tblVenta.getColumnModel().getColumn(1).setPreferredWidth(113);
		tblVenta.getColumnModel().getColumn(2).setPreferredWidth(226);
		tblVenta.getColumnModel().getColumn(3).setPreferredWidth(77);
		tblVenta.getColumnModel().getColumn(4).setPreferredWidth(77);
		tblVenta.getColumnModel().getColumn(5).setPreferredWidth(77);
	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
	
	private String leerCliente() {
		
		String cliente = txtCliente.getText().trim();
		
		if (cliente.isEmpty()) {
			return null;
		}
		
		return cliente;
	}
	
	private String leerFechaBoleta() {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
			return sdf.format(txtFecha.getDate());
		} catch (Exception e) {
			return null;
		}
	}
	
	private String leerCodigoProducto() {
		String codigo = txtCodigo.getText().trim();
		
		if (codigo.isEmpty()) {
			return null;
		}
		
		return codigo;
	}
	
	private String leerDescripcionProducto() {
		String descripcion = txtDescripcionProducto.getText().trim();
		
		if (descripcion.isEmpty()) {
			return null;
		}
		
		return descripcion;
	}
	
	private int leerStock() {
		
		String stock = txtStock.getText().trim();
		
		if (stock.isEmpty()) {
			return -1;
		}
		
		return Integer.parseInt(stock);
	}
	
	private int leerCantidadAComprar() {
		String cantidad = txtCantidad.getText().trim();
		
		if (cantidad.isEmpty()) {
			aviso("El campo Cantidad está vacío");
			return -1;
		}
		
		if (cantidad.matches("[0-9]+")) {
			aviso("Ingrese una Cantidad válidad");
			return -1;
		}
		
		int numCantidad = Integer.parseInt(cantidad);
		
		if (numCantidad > leerStock()) {
			aviso("Ingrese una cantidad menor o igual al Stock");
			return -1;
		}
		
		return numCantidad;
	}
	
	private double leerPrecioProducto() {
		String precio = txtPrecio.getText().trim();
		
		if (precio.isEmpty()) {
			return -1;
		}
		
		return Double.parseDouble(precio);
	}
	
	private void aviso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Aviso", 2);
	}
	
}
