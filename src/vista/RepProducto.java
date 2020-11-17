package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RepProducto extends JPanel {


	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTable tblProductos;
	private JComboBox<String> cboMarca;
	private JComboBox<String> cboTipoProducto;

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
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pProducto.setBorder(titled);
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
		
		cboMarca = new JComboBox<String>();
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione...", "Ejemplo"}));
		cboMarca.setBounds(111, 60, 241, 20);
		pProducto.add(cboMarca);
		
		cboTipoProducto = new JComboBox<String>();
		cboTipoProducto.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione...", "Figuras de Acci\u00F3n", "Modelismo", "Modelismo 3D", "Juegos de Mesa", "Miniaturas", "Consolas y Videojuegos", "Antiguedades", "Varios"}));
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
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	private String leerCodigo() {
		String codigo = txtCodigo.getText().toUpperCase().trim();

		if (codigo.isEmpty()) {
			aviso("El campo C�digo est� vac�o");
			return null;
		}

		if (!codigo.matches("PROD[0-9]{4}")) {
			aviso("Ingrese un c�digo v�lido (PRODXXXX)");
			return null;
		}

		return codigo;
	}
	
	private int leerMarca() {
		int marca = cboMarca.getSelectedIndex();

		if (marca == -1 || marca == 0) {
			aviso("Seleccione una Marca v�lida");
			return -1;
		}

		return marca;
	}
	
	private int leerTipo() {
		int tipo = cboTipoProducto.getSelectedIndex();

		if (tipo == -1 || tipo == 0) {
			aviso("Seleccione un Tipo v�lido");
			return -1;
		}

		return tipo;
	}
	
	private void aviso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Aviso", 2);
	}
}
