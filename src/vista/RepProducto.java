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

import mantenimientos.GestionMarcaProducto;
import mantenimientos.GestionTipoProducto;
import model.MarcaProducto;
import model.TipoProducto;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class RepProducto extends JPanel {


	private static final long serialVersionUID = 1L;
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
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblMarca.setBounds(22, 31, 39, 19);
		pProducto.add(lblMarca);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTipo.setBounds(22, 73, 28, 19);
		pProducto.add(lblTipo);
		
		cboMarca = new JComboBox<String>();
		cboMarca.setBounds(110, 32, 241, 20);
		pProducto.add(cboMarca);
		
		cboTipoProducto = new JComboBox<String>();
		cboTipoProducto.setBounds(110, 74, 241, 20);
		pProducto.add(cboTipoProducto);
		
		JButton btnConsultar = new JButton("CONSULTAR");		
		btnConsultar.setBounds(438, 19, 117, 43);
		pProducto.add(btnConsultar);
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setOpaque(true);
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(Color.GRAY);
		
		JButton btnImprimir = new JButton("IMPRIMIR");		
		btnImprimir.setBounds(438, 84, 117, 43);
		pProducto.add(btnImprimir);
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setContentAreaFilled(false);
		btnImprimir.setOpaque(true);
		btnImprimir.setBorder(null);
		btnImprimir.setBackground(Color.GRAY);
		
		llenarCboMarca();
		llenarCboTipos();
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	private void llenarCboMarca() {
		
		cboMarca.addItem("Seleccione Marca...");
		ArrayList<MarcaProducto> lista = new GestionMarcaProducto().listado();
		
		if (lista == null) {
			System.out.println("Hubo un problema al cargar la lista de marcas");
		} else {
			for (MarcaProducto marca : lista) {
				cboMarca.addItem(marca.getIdMarca()+".- " + marca.getDescripcion());
			}
		}
		
	}
	
	private void llenarCboTipos() {
		cboTipoProducto.addItem("Seleccione Tipo...");
		ArrayList<TipoProducto> lista = new GestionTipoProducto().listado();
		
		if (lista == null) {
			System.out.println("Hubo un problema al cargar la lista de tipos");
		} else {
			for (TipoProducto tipo : lista) {
				cboTipoProducto.addItem(tipo.getIdTipo()+".- " + tipo.getDescripcion());
			}
		}
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
