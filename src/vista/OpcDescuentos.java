package vista;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class OpcDescuentos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtPrecioActual;
	private JTextField txtDescripcion;
	private JTextField txtDescuento1;
	private JTextField txtDescuento2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtDescuento3;
	private JComboBox<String> cboTipoDescuento1;
	private JComboBox<String> cboTipoDescuento2;
	private JComboBox<String> cboTipoDescuento3;
	private JComboBox<String> cboLista;
	private JRadioButton rdbtnTipoProducto;
	private JRadioButton rdbtnMarcaProducto;

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
		
		txtDescuento1 = new JTextField();
		txtDescuento1.setColumns(10);
		txtDescuento1.setBounds(317, 100, 115, 20);
		pProducto.add(txtDescuento1);
		
		cboTipoDescuento1 = new JComboBox<String>();
		cboTipoDescuento1.setModel(new DefaultComboBoxModel<String>(new String[] {"Tipo de descuento...", "Num\u00E9rico", "Porcentual"}));
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
		btnGenerarDescuentoProducto.setBounds(486, 75, 131, 38);
		pProducto.add(btnGenerarDescuentoProducto);
		
		JPanel pTipoMarca = new JPanel();
		pTipoMarca.setLayout(null);
		pTipoMarca.setBorder(crearBordeTitulo("Por Tipo y Marca"));
		pTipoMarca.setBounds(33, 225, 627, 122);
		panelDescuentos.add(pTipoMarca);
		
		JLabel lblSeleccionar1 = new JLabel("SELECCIONAR");
		lblSeleccionar1.setBounds(22, 21, 70, 14);
		pTipoMarca.add(lblSeleccionar1);
		
		cboTipoDescuento2 = new JComboBox<String>();
		cboTipoDescuento2.setModel(new DefaultComboBoxModel<String>(new String[] {"Tipo de descuento...", "Num\u00E9rico", "Porcentual"}));
		cboTipoDescuento2.setBounds(22, 46, 136, 24);
		pTipoMarca.add(cboTipoDescuento2);
		
		JLabel lblTipoProducto = new JLabel("Tipo de Producto");
		lblTipoProducto.setBounds(194, 23, 81, 14);
		pTipoMarca.add(lblTipoProducto);
		
		rdbtnTipoProducto = new JRadioButton("");
		buttonGroup.add(rdbtnTipoProducto);
		rdbtnTipoProducto.setSelected(true);
		rdbtnTipoProducto.setBounds(281, 19, 21, 21);
		pTipoMarca.add(rdbtnTipoProducto);
		
		JLabel lblMarcaProducto = new JLabel("Marca Producto");
		lblMarcaProducto.setBounds(194, 53, 75, 14);
		pTipoMarca.add(lblMarcaProducto);
		
		rdbtnMarcaProducto = new JRadioButton("");
		buttonGroup.add(rdbtnMarcaProducto);
		rdbtnMarcaProducto.setBounds(281, 49, 21, 21);
		pTipoMarca.add(rdbtnMarcaProducto);
		
		JLabel lblSeleccionar2 = new JLabel("SELECCIONAR");
		lblSeleccionar2.setBounds(327, 21, 70, 14);
		pTipoMarca.add(lblSeleccionar2);
		
		cboLista = new JComboBox<String>();
		cboLista.setModel(new DefaultComboBoxModel<String>(new String[] {"Lista de Tipos...","Figuras de Acci\u00F3n", "Modelismo", "Modelismo 3D", "Juegos de Mesa", "Miniaturas", "Consolas y Videojuegos", "Antiguedades", "Varios"}));
		cboLista.setBounds(327, 46, 136, 24);
		pTipoMarca.add(cboLista);
		
		JLabel lblDescuento2 = new JLabel("DESCUENTO");
		lblDescuento2.setBounds(224, 93, 60, 14);
		pTipoMarca.add(lblDescuento2);
		
		txtDescuento2 = new JTextField();
		txtDescuento2.setColumns(10);
		txtDescuento2.setBounds(327, 90, 115, 20);
		pTipoMarca.add(txtDescuento2);
		
		JButton btnGenerarDescuentoTipoMarca = new JButton("GENERAR");
		btnGenerarDescuentoTipoMarca.setForeground(Color.WHITE);
		btnGenerarDescuentoTipoMarca.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGenerarDescuentoTipoMarca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerarDescuentoTipoMarca.setContentAreaFilled(false);
		btnGenerarDescuentoTipoMarca.setOpaque(true);
		btnGenerarDescuentoTipoMarca.setBorder(null);
		btnGenerarDescuentoTipoMarca.setBackground(new Color(19, 205, 210));
		btnGenerarDescuentoTipoMarca.setBounds(486, 37, 131, 38);
		pTipoMarca.add(btnGenerarDescuentoTipoMarca);
		
		JPanel pTodo = new JPanel();
		pTodo.setBorder(crearBordeTitulo("Todos"));
		pTodo.setLayout(null);
		pTodo.setBorder(crearBordeTitulo("Producto"));
		pTodo.setBounds(33, 368, 627, 99);
		panelDescuentos.add(pTodo);
		
		JLabel lblDescuento3 = new JLabel("DESCUENTO");
		lblDescuento3.setBounds(186, 41, 60, 14);
		pTodo.add(lblDescuento3);
		
		txtDescuento3 = new JTextField();
		txtDescuento3.setColumns(10);
		txtDescuento3.setBounds(186, 66, 115, 20);
		pTodo.add(txtDescuento3);
		
		JButton btnGenerarDescuentoTodo = new JButton("GENERAR");
		btnGenerarDescuentoTodo.setForeground(Color.WHITE);
		btnGenerarDescuentoTodo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGenerarDescuentoTodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerarDescuentoTodo.setContentAreaFilled(false);
		btnGenerarDescuentoTodo.setOpaque(true);
		btnGenerarDescuentoTodo.setBorder(null);
		btnGenerarDescuentoTodo.setBackground(new Color(19, 205, 210));
		btnGenerarDescuentoTodo.setBounds(486, 41, 131, 38);
		pTodo.add(btnGenerarDescuentoTodo);
		
		JLabel lblSeleccionar3 = new JLabel("SELECCIONAR");
		lblSeleccionar3.setBounds(20, 41, 70, 14);
		pTodo.add(lblSeleccionar3);
		
		cboTipoDescuento3 = new JComboBox<String>();
		cboTipoDescuento3.setModel(new DefaultComboBoxModel<String>(new String[] {"Tipo de descuento...", "Num\u00E9rico", "Porcentual"}));
		cboTipoDescuento3.setBounds(20, 64, 136, 24);
		pTodo.add(cboTipoDescuento3);
		
		JLabel lblNewLabel = new JLabel("* Todos los productos tendr\u00E1n descuentos");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(20, 15, 226, 15);
		pTodo.add(lblNewLabel);
		
		JButton btnActivar = new JButton("ACTIVAR");
		btnActivar.setForeground(Color.WHITE);
		btnActivar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnActivar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActivar.setContentAreaFilled(false);
		btnActivar.setOpaque(true);
		btnActivar.setBorder(null);
		btnActivar.setBackground(Color.GRAY);
		btnActivar.setBounds(200, 487, 130, 42);
		panelDescuentos.add(btnActivar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(Color.GRAY);
		btnCancelar.setBounds(377, 487, 130, 42);
		panelDescuentos.add(btnCancelar);

	}
	
	private String leerCodigoProducto() {
		String codigo = txtCodigo.getText().trim();
		
		if (codigo.isEmpty()) {
			return null;
		}
		
		return codigo;
	}
	
	private String leerDescripcion() {
		String descuento = txtDescripcion.getText().trim();
		
		if (descuento.isEmpty()) {
			return null;
		}
		
		return descuento;
	}
	
	private double leerPrecioActual() {
		String precio = txtPrecioActual.getText().trim();
		
		if (precio.isEmpty()) {
			return -1;
		}
		
		return Double.parseDouble(precio);
	}
	
	private double leerDescuento01() {
		return verificarObtenerDescuento(txtDescuento1);
	}
	
	private int leerTipoDescuento01() {
		int tipo = cboTipoDescuento1.getSelectedIndex();
		
		if (tipo == -1 || tipo == 0) {
			return -1;
		}
		
		return tipo;
	}
	
	private int leerTipoDescuento02() {
		int tipo = cboTipoDescuento2.getSelectedIndex();
		
		if (tipo == -1 || tipo == 0) {
			return -1;
		}
		
		return tipo;
	}
	
	private double leerDescuento02() {
		return verificarObtenerDescuento(txtDescuento2);
	}
	
	private int leerLista() {
		int tipoLista = cboLista.getSelectedIndex();
		
		if (tipoLista == -1 || tipoLista == 0) {
			return -1;
		}
		
		return tipoLista;
	}
	
	private int leerTipoDescuento03() {
		int tipo = cboTipoDescuento3.getSelectedIndex();
		
		if (tipo == -1 || tipo == 0) {
			return -1;
		}
		
		return tipo;
	}
	
	private double leerDescuento03() {
		return verificarObtenerDescuento(txtDescuento3);
	}
	
	private double verificarObtenerDescuento(JTextField txt) {
		String descuento = txt.getText().trim();
		
		if (descuento.isEmpty()) {
			aviso("El Campo Descuento está vacío");
			txt.requestFocus();
			return -1;
		}
		
		if (descuento.matches("[0-9]+([.][0-9]{1,2})?")) {
			aviso("Ingrese un Descuento válido");
			txt.requestFocus();
			return -1;
		}
		
		double desc = Double.parseDouble(descuento);
		
		if (desc >= leerPrecioActual()) {
			aviso("El descuento no puede ser mayor que el precio Actual o Promedio");
			txt.requestFocus();
			return -1;
		}
		
		return desc;
	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
	
	private void aviso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Aviso", 2);
	}
}
