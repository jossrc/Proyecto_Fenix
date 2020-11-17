package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MantProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	
	private JTable tblProducto;
	private JComboBox<String> cboMarca;
	private JComboBox<String> cboTipo;

	
	public MantProducto() {
		setLayout(null);
		
		//Dando Forma al Panel
		JPanel panelProducto = new JPanel();
		panelProducto.setBounds(0, 0, 817, 470);
		add(panelProducto);
		panelProducto.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(37, 45, 46, 14);
		panelProducto.add(lblCodigo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 600, 271);
		panelProducto.add(scrollPane);
		
		tblProducto = new JTable();
		scrollPane.setViewportView(tblProducto);
		
		JLabel lblDescripcion = new JLabel("Descrcipción");
		lblDescripcion.setBounds(37, 70, 62, 14);
		panelProducto.add(lblDescripcion);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(37, 95, 46, 14);
		panelProducto.add(lblStock);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(37, 120, 46, 14);
		panelProducto.add(lblMarca);
		
		
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(109, 42, 323, 20);
		panelProducto.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(109, 67, 323, 20);
		txtDescripcion.setColumns(10);
		panelProducto.add(txtDescripcion);
		
		txtStock = new JTextField();
		txtStock.setBounds(109, 92, 323, 20);
		txtStock.setColumns(10);
		panelProducto.add(txtStock);

		JButton btnLimpiar = new JButton("Limpiar");		
		btnLimpiar.setBounds(477, 45, 122, 53);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setContentAreaFilled(false);
		btnLimpiar.setOpaque(true);
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		panelProducto.add(btnLimpiar);
		
		JButton btnVerTodo = new JButton("Ver Todo");
		btnVerTodo.setBounds(477, 106, 122, 53);
		btnVerTodo.setForeground(Color.WHITE);
		btnVerTodo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVerTodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerTodo.setContentAreaFilled(false);
		btnVerTodo.setOpaque(true);
		btnVerTodo.setBorder(null);
		btnVerTodo.setBackground(Color.LIGHT_GRAY);		
		panelProducto.add(btnVerTodo);
		
		JButton btnAgregar = new JButton("Agregar");		
		btnAgregar.setBounds(633, 189, 122, 53);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setOpaque(true);
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(Color.LIGHT_GRAY);
		panelProducto.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(633, 253, 122, 53);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setOpaque(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(Color.LIGHT_GRAY);
		panelProducto.add(btnEditar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(633, 317, 122, 53);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		panelProducto.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(633, 381, 122, 53);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		panelProducto.add(btnEliminar);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(37, 145, 46, 14);
		panelProducto.add(lblTipo);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione...", "Figuras de Acci\u00F3n", "Modelismo", "Modelismo 3D", "Juegos de Mesa", "Miniaturas", "Consolas y Videojuegos", "Antiguedades", "Varios"}));
		cboTipo.setBounds(109, 148, 323, 20);
		panelProducto.add(cboTipo);
		
		cboMarca = new JComboBox<String>();
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione...", "Probando"}));
		cboMarca.setBounds(109, 117, 323, 20);
		panelProducto.add(cboMarca);
		
		btnVerTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

	}
}
