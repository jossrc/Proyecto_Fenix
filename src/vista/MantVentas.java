package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MantVentas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtCliente;
	private JTextField txtBoleta;
	private JTextField txtCodigo;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JTextField txtDescripcionProducto;
	private JTextField txtStock;

	public MantVentas() {
		setLayout(null);
		
		JPanel panelVentas = new JPanel();
		panelVentas.setBounds(0, 0, 817, 470);
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
		
		JDateChooser txtFecha = new JDateChooser();
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
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(473, 44, 115, 20);
		pDatosProducto.add(txtPrecio);
		
		JLabel lblDescripcionProducto = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcionProducto.setBounds(22, 75, 69, 14);
		pDatosProducto.add(lblDescripcionProducto);
		
		txtDescripcionProducto = new JTextField();
		txtDescripcionProducto.setBounds(22, 100, 218, 20);
		pDatosProducto.add(txtDescripcionProducto);
		txtDescripcionProducto.setColumns(10);
		
		JLabel lblStock = new JLabel("STOCK");
		lblStock.setBounds(483, 75, 33, 14);
		pDatosProducto.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(473, 100, 115, 20);
		pDatosProducto.add(txtStock);

	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
}
