package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionVendedores;
import model.Vendedor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MantVendedor extends JPanel {
private static final long serialVersionUID = 1L;
	
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTable tblVendedor;
	private DefaultTableModel model;

	
	public MantVendedor() {
		setLayout(null);
		
		//Dando Forma al Panel
		JPanel panelVendedor = new JPanel();
		panelVendedor.setBounds(0, 0, 817, 470);
		add(panelVendedor);
		panelVendedor.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(37, 67, 46, 14);
		panelVendedor.add(lblNombres);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 600, 271);
		panelVendedor.add(scrollPane);
		
		tblVendedor = new JTable();		
		model = new DefaultTableModel();
		tblVendedor.setModel(model);
		model.addColumn("DNI");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Dirección");
		model.addColumn("Telefono");		
		scrollPane.setViewportView(tblVendedor);		
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(37, 92, 46, 14);
		panelVendedor.add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(37, 39, 46, 14);
		panelVendedor.add(lblDni);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(37, 120, 46, 14);
		panelVendedor.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(37, 145, 46, 14);
		panelVendedor.add(lblDireccion);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(109, 64, 323, 20);
		panelVendedor.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(109, 89, 323, 20);
		txtApellidos.setColumns(10);
		panelVendedor.add(txtApellidos);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(109, 36, 323, 20);
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
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		
		btnVerTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarVendedor();
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarVendedor();
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarVendedor();
			}
		});
		
		tblVendedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = tblVendedor.getSelectedRow();
				
				if (fila != -1) {
					String dni = tblVendedor.getValueAt(fila, 0).toString();
					
					txtDNI.setText(dni);
					buscarVendedor();
				}
			}
		});
	}
	
	private void actualizarVendedor() {
		Vendedor vendedor = crearVendedor();
		
		if (vendedor != null) {
			int ok = new GestionVendedores().actualizar(vendedor);
			
			if (ok == 0) {
				aviso("Oops algo salió mal. No se pudo actualizar Vendedor");
			} else {
				JOptionPane.showMessageDialog(this, "Vendedor actualizado correctamente");
				limpiar();
			}
		}
	}
	
	private void buscarVendedor() {
		String dni = leerDNI();
		
		if (dni != null) {
			
			Vendedor v = new GestionVendedores().buscar(dni);
			
			if (v == null) {
				aviso("Oops no se pudo encontrar Vendedor");
			} else {
				txtNombres.setText(v.getNombre());
				txtApellidos.setText(v.getApellido());
				txtTelefono.setText(v.getTelefono());
				txtDireccion.setText(v.getDireccion());
			}
		}
	}
	
	private void listado() {
		ArrayList<Vendedor> lista = new GestionVendedores().listado();
		
		if (lista == null){
			JOptionPane.showMessageDialog(this, "Listado vacio");
		} else{
			model.setRowCount(0);
			for (Vendedor v : lista){
				insertarNuevaFila(v);				
			}
		}
	}
	
	private void registrarVendedor() {
		Vendedor vendedor = crearVendedor();
		
		if (vendedor != null) {
			int ok = new GestionVendedores().registrar(vendedor);
			
			if (ok == 0) {
				aviso("Oops algo salió mal. No se pudo registrar Vendedor");
			} else {
				JOptionPane.showMessageDialog(this, "Nuevo Vendedor registrado");
				limpiar();
			}
		}
	}
	
	private Vendedor crearVendedor() {
		String dni = leerDNI();
		String nombre, apellido, telefono, direccion;
		
		if (dni != null) {
			nombre = leerNombre();
			if (nombre != null) {
				apellido = leerApellido();
				if (apellido != null) {
					telefono = leerTelefono();
					if (telefono != null) {
						direccion = leerDireccion();
						if (direccion != null) {			
							return new Vendedor(0, dni, nombre, apellido, direccion, telefono);
						}
					}
				}
			}
		}
		
		return null;
	}

	private String leerDNI() {

		String dni = txtDNI.getText().trim();

		if (dni.isEmpty()) {
			aviso("El campo DNI está vacío");
			return null;
		}

		if (!dni.matches("^[0-9]{8}$")) {
			aviso("Ingrese un DNI válido");
			return null;
		}

		return dni;

	}

	private String leerNombre() {
		String nombre = txtNombres.getText().trim();

		if (nombre.isEmpty()) {
			aviso("El campo nombre está vacío");
			return null;
		}

		if (!nombre.matches("^(?=.{3,15}$)[A-ZÁÉÍÓÚa-zñáéíóú]+(?:\\s[A-ZÁÉÍÓÚa-zñáéíóú]+)?$")) {
			aviso("Ingrese un nombre válido");
			return null;
		}

		return nombre;

	}

	private String leerApellido() {
		String apellido = txtApellidos.getText().trim();

		if (apellido.isEmpty()) {
			aviso("El campo apellido está vacío");
			return null;
		}

		if (!apellido.matches("^(?=.{3,15}$)[A-ZÁÉÍÓÚa-zñáéíóú]+(?:\\s[A-ZÁÉÍÓÚa-zñáéíóú]+)?$")) {
			aviso("Ingrese un apellido válido");
			return null;
		}

		return apellido;
	}

	private String leerTelefono() {

		String telefono = txtTelefono.getText().trim();

		if (telefono.isEmpty()) {
			aviso("El campo Telefono está vacío");
			return null;
		}

		if (!telefono.matches("([0-9]{7,9})")) {
			aviso("Ingrese un teléfono válido");
			return null;
		}

		return telefono;

	}

	private String leerDireccion() {
		String direccion = txtDireccion.getText().trim();
		if (direccion.isEmpty()) {
			aviso("El campo Dirección está vacío");
			return null;
		}

		return direccion;
	}

	private void insertarNuevaFila(Vendedor v) {
		Object datos[] = {v.getDni(), v.getNombre(), v.getApellido(), v.getDireccion(), v.getTelefono()};
		model.addRow(datos);
	}
	
	private void aviso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Aviso", 2);
	}
	
	private void limpiar() {
		txtDNI.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		
		txtDNI.requestFocus();
		txtDNI.selectAll();
	}
	
	
}
