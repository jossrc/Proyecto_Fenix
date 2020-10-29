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

public class OpcDescuentos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtPrecioActual;
	private JTextField txtDescripcion;
	private JTextField txtDescuento;

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
		
		JLabel lblDescuento = new JLabel("DESCUENTO");
		lblDescuento.setBounds(317, 75, 60, 14);
		pProducto.add(lblDescuento);
		
		txtDescuento = new JTextField();
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(317, 100, 115, 20);
		pProducto.add(txtDescuento);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Tipo...", "Num\u00E9rico", "Porcentual"}));
		comboBox.setBounds(470, 31, 136, 24);
		pProducto.add(comboBox);
		
		JButton btnGenerar = new JButton("GENERAR");		
		btnGenerar.setForeground(Color.WHITE);
		btnGenerar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGenerar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerar.setContentAreaFilled(false);
		btnGenerar.setOpaque(true);
		btnGenerar.setBorder(null);
		btnGenerar.setBackground(new Color(19, 205, 210));
		btnGenerar.setBounds(475, 82, 131, 38);
		pProducto.add(btnGenerar);

	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
}
