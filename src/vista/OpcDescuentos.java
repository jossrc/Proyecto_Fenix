package vista;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class OpcDescuentos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtPrecioActual;
	private JTextField txtDescripcion;
	private JTextField txtDescuento;
	private JTextField textField;

	public OpcDescuentos() {
		setLayout(null);
		
		JPanel panelDescuentos = new JPanel();
		panelDescuentos.setBounds(0, 0, 827, 551);
		add(panelDescuentos);
		panelDescuentos.setLayout(null);
		
		JLabel lblGenerarDescuento = new JLabel("Generar descuento");
		lblGenerarDescuento.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblGenerarDescuento.setBounds(304, 25, 218, 32);
		panelDescuentos.add(lblGenerarDescuento);
		
		JPanel pProducto = new JPanel();
		pProducto.setLayout(null);
		pProducto.setBorder(crearBordeTitulo("Producto"));
		pProducto.setBounds(33, 78, 627, 132);
		panelDescuentos.add(pProducto);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(22, 19, 41, 14);
		pProducto.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(21, 44, 219, 20);
		pProducto.add(txtCodigo);
		
		JButton btnBuscarProducto = new JButton("");
		btnBuscarProducto.setBounds(250, 44, 26, 20);
		pProducto.add(btnBuscarProducto);
		
		JLabel lblPrecioActual = new JLabel("PRECIO ACTUAL");
		lblPrecioActual.setBounds(317, 19, 80, 14);
		pProducto.add(lblPrecioActual);
		
		txtPrecioActual = new JTextField();
		txtPrecioActual.setEditable(false);
		txtPrecioActual.setColumns(10);
		txtPrecioActual.setBounds(317, 44, 115, 20);
		pProducto.add(txtPrecioActual);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcion.setBounds(22, 75, 69, 14);
		pProducto.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(22, 100, 218, 20);
		pProducto.add(txtDescripcion);
		
		JLabel lblDescuento1 = new JLabel("DESCUENTO");
		lblDescuento1.setBounds(317, 75, 60, 14);
		pProducto.add(lblDescuento1);
		
		txtDescuento = new JTextField();
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(317, 100, 115, 20);
		pProducto.add(txtDescuento);
		
		JComboBox<String> cboTipoDescuento1 = new JComboBox<String>();
		cboTipoDescuento1.setModel(new DefaultComboBoxModel<String>(new String[] {"Tipo...", "Num\u00E9rico", "Porcentual"}));
		cboTipoDescuento1.setBounds(470, 31, 136, 24);
		pProducto.add(cboTipoDescuento1);
		
		JButton btnGenerarDescuentoProducto = new JButton("GENERAR");		
		btnGenerarDescuentoProducto.setForeground(Color.WHITE);
		btnGenerarDescuentoProducto.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGenerarDescuentoProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerarDescuentoProducto.setContentAreaFilled(false);
		btnGenerarDescuentoProducto.setOpaque(true);
		btnGenerarDescuentoProducto.setBorder(null);
		btnGenerarDescuentoProducto.setBackground(new Color(19, 205, 210));
		btnGenerarDescuentoProducto.setBounds(475, 82, 131, 38);
		pProducto.add(btnGenerarDescuentoProducto);
		
		JPanel pTipoMarca = new JPanel();
		pTipoMarca.setLayout(null);
		pTipoMarca.setBorder(crearBordeTitulo("Por Tipo y Marca"));
		pTipoMarca.setBounds(33, 225, 757, 86);
		panelDescuentos.add(pTipoMarca);
		
		JLabel lblSeleccionar1 = new JLabel("SELECCIONAR");
		lblSeleccionar1.setBounds(22, 21, 70, 14);
		pTipoMarca.add(lblSeleccionar1);
		
		JComboBox<String> cboTipoDescuento2 = new JComboBox<String>();
		cboTipoDescuento2.setModel(new DefaultComboBoxModel<String>(new String[] {"Tipo...", "Num\u00E9rico", "Porcentual"}));
		cboTipoDescuento2.setBounds(22, 46, 136, 24);
		pTipoMarca.add(cboTipoDescuento2);
		
		JLabel lblTipoProducto = new JLabel("Tipo de Producto");
		lblTipoProducto.setBounds(194, 23, 81, 14);
		pTipoMarca.add(lblTipoProducto);
		
		JRadioButton rdbtnTipoProducto = new JRadioButton("");
		rdbtnTipoProducto.setSelected(true);
		rdbtnTipoProducto.setBounds(281, 19, 21, 21);
		pTipoMarca.add(rdbtnTipoProducto);
		
		JLabel lblMarcaProducto = new JLabel("Marca Producto");
		lblMarcaProducto.setBounds(194, 53, 75, 14);
		pTipoMarca.add(lblMarcaProducto);
		
		JRadioButton rdbtnMarcaProducto = new JRadioButton("");
		rdbtnMarcaProducto.setBounds(281, 49, 21, 21);
		pTipoMarca.add(rdbtnMarcaProducto);
		
		JLabel lblSeleccionar2 = new JLabel("SELECCIONAR");
		lblSeleccionar2.setBounds(327, 21, 70, 14);
		pTipoMarca.add(lblSeleccionar2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Lista de Tipos...","Figuras de Acci\u00F3n", "Modelismo", "Modelismo 3D", "Juegos de Mesa", "Miniaturas", "Consolas y Videojuegos", "Antiguedades", "Varios"}));
		comboBox.setBounds(327, 46, 136, 24);
		pTipoMarca.add(comboBox);
		
		JLabel lblDescuento2 = new JLabel("DESCUENTO");
		lblDescuento2.setBounds(481, 21, 60, 14);
		pTipoMarca.add(lblDescuento2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(481, 48, 115, 20);
		pTipoMarca.add(textField);
		
		JButton btnGenerarDescuentoTipoMarca = new JButton("GENERAR");
		btnGenerarDescuentoTipoMarca.setForeground(Color.WHITE);
		btnGenerarDescuentoTipoMarca.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGenerarDescuentoTipoMarca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerarDescuentoTipoMarca.setContentAreaFilled(false);
		btnGenerarDescuentoTipoMarca.setOpaque(true);
		btnGenerarDescuentoTipoMarca.setBorder(null);
		btnGenerarDescuentoTipoMarca.setBackground(new Color(19, 205, 210));
		btnGenerarDescuentoTipoMarca.setBounds(616, 21, 131, 38);
		pTipoMarca.add(btnGenerarDescuentoTipoMarca);

	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
}
