package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class OpTasaCambios extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCantidadMonedaOriginal;
	private JTextField txtCantidadMonedaFinal;
	private JTextField txtTasaOriginal;
	private JTextField txtTasaFinal;
	private JComboBox<String> cboMonedaOrigen;
	private JComboBox<String> cboMonedaFinal;

	/**
	 * Create the panel.
	 */
	public OpTasaCambios() {
		setLayout(null);

		JPanel panelTcambios = new JPanel();
		panelTcambios.setBounds(0, 0, 827, 551);
		add(panelTcambios);
		panelTcambios.setLayout(null);
		
		JLabel lblTcambios = new JLabel("Tasa de Cambios");
		lblTcambios.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblTcambios.setBounds(304, 25, 218, 32);
		panelTcambios.add(lblTcambios);
		
		JPanel pMoneda = new JPanel();
		pMoneda.setLayout(null);
		pMoneda.setBorder(crearBordeTitulo("Moneda"));
		pMoneda.setBounds(33, 102, 627, 108);
		panelTcambios.add(pMoneda);
		
		JLabel lblDe = new JLabel("De:");
		lblDe.setBounds(28, 32, 46, 14);
		pMoneda.add(lblDe);
		
		JLabel lblA = new JLabel("A:");
		lblA.setBounds(276, 32, 46, 14);
		pMoneda.add(lblA);
		
		cboMonedaOrigen = new JComboBox<String>();
		cboMonedaOrigen.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione...", "D\u00F3lares", "Euros", "Libras Esterlinas", "Pesos Argentinos", "Bitcoin"}));
		cboMonedaOrigen.setBounds(28, 58, 153, 20);
		pMoneda.add(cboMonedaOrigen);
		
		cboMonedaFinal = new JComboBox<String>();
		cboMonedaFinal.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione...", "D\u00F3lares", "Euros", "Libras Esterlinas", "Pesos Argentinos", "Bitcoin"}));
		cboMonedaFinal.setBounds(276, 57, 153, 20);
		pMoneda.add(cboMonedaFinal);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(482, 46, 107, 40);
		btnAplicar.setForeground(Color.WHITE);
		btnAplicar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAplicar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAplicar.setContentAreaFilled(false);
		btnAplicar.setOpaque(true);
		btnAplicar.setBorder(null);
		btnAplicar.setBackground(new Color(19, 205, 210));
		pMoneda.add(btnAplicar);
				
		JLabel lblArrow01 = new JLabel("");
		lblArrow01.setIcon(new ImageIcon(OpTasaCambios.class.getResource("/img/right-arrow_resize.png")));
		lblArrow01.setBounds(212, 58, 54, 26);
		pMoneda.add(lblArrow01);
		
		JPanel pCantidad = new JPanel();
		pCantidad.setLayout(null);
		pCantidad.setBorder(crearBordeTitulo("Cantidad"));
		pCantidad.setBounds(33, 234, 627, 132);
		panelTcambios.add(pCantidad);
		
		txtCantidadMonedaOriginal = new JTextField();
		txtCantidadMonedaOriginal.setBounds(38, 60, 168, 20);
		pCantidad.add(txtCantidadMonedaOriginal);
		txtCantidadMonedaOriginal.setColumns(10);
		
		txtCantidadMonedaFinal = new JTextField();
		txtCantidadMonedaFinal.setColumns(10);
		txtCantidadMonedaFinal.setBounds(276, 60, 168, 20);
		pCantidad.add(txtCantidadMonedaFinal);
		
		JLabel lblArrow02 = new JLabel("");
		lblArrow02.setIcon(new ImageIcon(OpTasaCambios.class.getResource("/img/right-arrow_resize.png")));
		lblArrow02.setBounds(212, 60, 54, 26);
		pCantidad.add(lblArrow02);
		
		JPanel pTasa = new JPanel();
		pTasa.setLayout(null);
		pTasa.setBorder(crearBordeTitulo("Tasa de Conversión"));
		pTasa.setBounds(33, 391, 627, 132);
		panelTcambios.add(pTasa);
		
		txtTasaOriginal = new JTextField();
		txtTasaOriginal.setColumns(10);
		txtTasaOriginal.setBounds(40, 52, 168, 20);
		pTasa.add(txtTasaOriginal);
		
		JLabel lblArrow03 = new JLabel("");
		lblArrow03.setIcon(new ImageIcon(OpTasaCambios.class.getResource("/img/right-arrow_resize.png")));
		lblArrow03.setBounds(214, 52, 54, 26);
		pTasa.add(lblArrow03);
		
		txtTasaFinal = new JTextField();
		txtTasaFinal.setColumns(10);
		txtTasaFinal.setBounds(278, 52, 168, 20);
		pTasa.add(txtTasaFinal);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.setBounds(483, 40, 107, 40);
		btnCambiar.setForeground(Color.WHITE);
		btnCambiar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCambiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCambiar.setContentAreaFilled(false);
		btnCambiar.setOpaque(true);
		btnCambiar.setBorder(null);
		btnCambiar.setBackground(new Color(19, 205, 210));
		pTasa.add(btnCambiar);

	}
	
	private int leerMonedaOrigen() {
		int tipo = cboMonedaOrigen.getSelectedIndex();
		
		if (tipo == -1 || tipo == 0) {
			return -1;
		}
		
		return tipo;		
	}
	
	private int leerMonedaFinal() {
		int tipo = cboMonedaFinal.getSelectedIndex();
		
		if (tipo == -1 || tipo == 0) {
			return -1;
		}
		
		return tipo;
	}
	
	private int leerCantidadMonedaOriginal() {
		String cantidad = txtCantidadMonedaOriginal.getText().trim();
		
		if (cantidad.isEmpty()) {
			aviso("La Cantidad 01 está vacía");
			return -1;
		}
		
		if (!cantidad.matches("[1-9]+")) {
			aviso("Ingrese un número válido para la Cantidad 01");
			return -1;
		}
		
		return Integer.parseInt(cantidad);
	}
	
	private int leerCantidadMonedaFinal() {
		String cantidad = txtCantidadMonedaFinal.getText().trim();
		
		if (cantidad.isEmpty()) {
			aviso("La Cantidad Final está vacía");
			return -1;
		}
		
		if (!cantidad.matches("[1-9]+")) {
			aviso("Ingrese un número válido para la Cantidad Final");
			return -1;
		}
		
		return Integer.parseInt(cantidad);
	}
	
	private double leerTasaOriginal() {
		String tasa = txtTasaOriginal.getText().trim();
		
		if (tasa.isEmpty()) {
			aviso("La Tasa Original está vacía");
			return -1;
		}
		
		if (!tasa.matches("")) {
			aviso("Ingrese un valor válido para la tasa Original");
			return -1;
		}
		
		return Double.parseDouble(tasa);
	}
	
	private double leerTasaFinal() {
		String tasa = txtTasaFinal.getText().trim();
		
		if (tasa.isEmpty()) {
			aviso("La Tasa Final está vacía");
			return -1;
		}
		
		if (!tasa.matches("")) {
			aviso("Ingrese un valor válido para la tasa Final");
			return -1;
		}
		
		return Double.parseDouble(tasa);
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
