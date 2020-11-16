package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
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
	private JTextField txtCantidadmonedaoriginal;
	private JTextField txtCantidadmonedafinal;
	private JTextField txttasaOriginal;
	private JTextField txtTasaFinal;

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
		
		JComboBox cmbMonedaOrigen = new JComboBox();
		cmbMonedaOrigen.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "D\u00F3lares", "Euros", "Libras Esterlinas", "Pesos Argentinos", "Bitcoin"}));
		cmbMonedaOrigen.setBounds(28, 58, 153, 20);
		pMoneda.add(cmbMonedaOrigen);
		
		JComboBox cmbMonedaFinal = new JComboBox();
		cmbMonedaFinal.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "D\u00F3lares", "Euros", "Libras Esterlinas", "Pesos Argentinos", "Bitcoin"}));
		cmbMonedaFinal.setBounds(276, 57, 153, 20);
		pMoneda.add(cmbMonedaFinal);
		
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
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OpTasaCambios.class.getResource("/img/right-arrow_resize.png")));
		label.setBounds(212, 58, 54, 26);
		pMoneda.add(label);
		
		JPanel pCantidad = new JPanel();
		pCantidad.setLayout(null);
		pCantidad.setBorder(crearBordeTitulo("Cantidad"));
		pCantidad.setBounds(33, 234, 627, 132);
		panelTcambios.add(pCantidad);
		
		txtCantidadmonedaoriginal = new JTextField();
		txtCantidadmonedaoriginal.setBounds(38, 60, 168, 20);
		pCantidad.add(txtCantidadmonedaoriginal);
		txtCantidadmonedaoriginal.setColumns(10);
		
		txtCantidadmonedafinal = new JTextField();
		txtCantidadmonedafinal.setColumns(10);
		txtCantidadmonedafinal.setBounds(276, 60, 168, 20);
		pCantidad.add(txtCantidadmonedafinal);
		
		JLabel lblArrow = new JLabel("");
		lblArrow.setIcon(new ImageIcon(OpTasaCambios.class.getResource("/img/right-arrow_resize.png")));
		lblArrow.setBounds(212, 60, 54, 26);
		pCantidad.add(lblArrow);
		
		JPanel pTasa = new JPanel();
		pTasa.setLayout(null);
		pTasa.setBorder(crearBordeTitulo("Tasa de Conversión"));
		pTasa.setBounds(33, 391, 627, 132);
		panelTcambios.add(pTasa);
		
		txttasaOriginal = new JTextField();
		txttasaOriginal.setColumns(10);
		txttasaOriginal.setBounds(40, 52, 168, 20);
		pTasa.add(txttasaOriginal);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(OpTasaCambios.class.getResource("/img/right-arrow_resize.png")));
		label_1.setBounds(214, 52, 54, 26);
		pTasa.add(label_1);
		
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

	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
}
