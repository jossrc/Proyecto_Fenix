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

public class MantVendedor extends JPanel {
private static final long serialVersionUID = 1L;
	
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTable tblVendedor;

	
	public MantVendedor() {
		setLayout(null);
		
		//Dando Forma al Panel
		JPanel panelVendedor = new JPanel();
		panelVendedor.setBounds(0, 0, 817, 470);
		add(panelVendedor);
		panelVendedor.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(37, 45, 46, 14);
		panelVendedor.add(lblNombres);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 600, 271);
		panelVendedor.add(scrollPane);
		
		tblVendedor = new JTable();
		scrollPane.setViewportView(tblVendedor);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(37, 70, 46, 14);
		panelVendedor.add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(37, 95, 46, 14);
		panelVendedor.add(lblDni);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(37, 120, 46, 14);
		panelVendedor.add(lblTelefono);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(37, 145, 46, 14);
		panelVendedor.add(lblDireccin);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(109, 42, 323, 20);
		panelVendedor.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(109, 67, 323, 20);
		txtApellidos.setColumns(10);
		panelVendedor.add(txtApellidos);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(109, 92, 323, 20);
		txtDNI.setColumns(10);
		panelVendedor.add(txtDNI);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(109, 117, 323, 20);
		txtTelefono.setColumns(10);
		panelVendedor.add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(109, 142, 323, 20);
		txtDireccion.setColumns(10);
		panelVendedor.add(txtDireccion);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(477, 45, 122, 53);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setContentAreaFilled(false);
		btnLimpiar.setOpaque(true);
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		panelVendedor.add(btnLimpiar);
		
		JButton btnVerTodo = new JButton("Ver Todo");
		btnVerTodo.setBounds(477, 106, 122, 53);
		btnVerTodo.setForeground(Color.WHITE);
		btnVerTodo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVerTodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerTodo.setContentAreaFilled(false);
		btnVerTodo.setOpaque(true);
		btnVerTodo.setBorder(null);
		btnVerTodo.setBackground(Color.LIGHT_GRAY);
		btnVerTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelVendedor.add(btnVerTodo);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(633, 189, 122, 53);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setOpaque(true);
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(Color.LIGHT_GRAY);
		panelVendedor.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(633, 253, 122, 53);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setOpaque(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(Color.LIGHT_GRAY);
		panelVendedor.add(btnEditar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(633, 317, 122, 53);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		panelVendedor.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(633, 381, 122, 53);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		panelVendedor.add(btnEliminar);
		
		JLabel lblVendedores = new JLabel("Vendedores");
		lblVendedores.setBounds(109, 11, 99, 14);
		panelVendedor.add(lblVendedores);

	}
}
