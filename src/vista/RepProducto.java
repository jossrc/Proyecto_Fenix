package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RepProducto extends JPanel {


	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTable tblProductos;

	public RepProducto() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 827, 570);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 215, 727, 310);
		panel.add(scrollPane);
		
		tblProductos = new JTable();
		scrollPane.setViewportView(tblProductos);
		
		JPanel pProducto = new JPanel();
		pProducto.setLayout(null);
		pProducto.setBounds(14, 29, 727, 149);
		panel.add(pProducto);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblCdigo.setBounds(23, 21, 45, 19);
		pProducto.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(111, 22, 241, 20);
		pProducto.add(txtCodigo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblMarca.setBounds(23, 59, 39, 19);
		pProducto.add(lblMarca);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTipo.setBounds(23, 101, 28, 19);
		pProducto.add(lblTipo);
		
		JComboBox<String> cboMarca = new JComboBox<String>();
		cboMarca.setBounds(111, 60, 241, 20);
		pProducto.add(cboMarca);
		
		JComboBox<String> cboTipoProducto = new JComboBox<String>();
		cboTipoProducto.setModel(new DefaultComboBoxModel<String>(new String[] {"Figuras de Acci\u00F3n", "Modelismo", "Modelismo 3D", "Juegos de Mesa", "Miniaturas", "Consolas y Videojuegos", "Antiguedades", "Varios"}));
		cboTipoProducto.setBounds(111, 102, 241, 20);
		pProducto.add(cboTipoProducto);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(466, 21, 117, 43);
		pProducto.add(btnConsultar);
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setOpaque(true);
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(Color.GRAY);
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setBounds(466, 89, 117, 43);
		pProducto.add(btnImprimir);
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setContentAreaFilled(false);
		btnImprimir.setOpaque(true);
		btnImprimir.setBorder(null);
		btnImprimir.setBackground(Color.GRAY);

	}
}
