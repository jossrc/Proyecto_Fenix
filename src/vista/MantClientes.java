package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionClientes;
import model.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MantClientes extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTable tblCliente;
	private DefaultTableModel model;

	public MantClientes() {
		setLayout(null);

		// Dando Forma al Panel
		JPanel panelClientes = new JPanel();
		panelClientes.setBounds(0, 0, 817, 470);
		add(panelClientes);
		panelClientes.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(37, 67, 46, 14);
		panelClientes.add(lblNombres);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 600, 271);
		panelClientes.add(scrollPane);

		tblCliente = new JTable();		
		model = new DefaultTableModel();
		tblCliente.setModel(model);
		scrollPane.setViewportView(tblCliente);
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Direcci�n");
		model.addColumn("Tel�fono");

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(37, 92, 46, 14);
		panelClientes.add(lblApellidos);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(37, 39, 46, 14);
		panelClientes.add(lblDni);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(37, 120, 46, 14);
		panelClientes.add(lblTelefono);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(37, 145, 46, 14);
		panelClientes.add(lblDireccin);

		txtNombres = new JTextField();
		txtNombres.setBounds(109, 64, 323, 20);
		panelClientes.add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(109, 89, 323, 20);
		txtApellidos.setColumns(10);
		panelClientes.add(txtApellidos);

		txtDNI = new JTextField();
		txtDNI.setBounds(109, 36, 174, 20);
		txtDNI.setColumns(10);
		panelClientes.add(txtDNI);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(109, 117, 323, 20);
		txtTelefono.setColumns(10);
		panelClientes.add(txtTelefono);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(109, 142, 323, 20);
		txtDireccion.setColumns(10);
		panelClientes.add(txtDireccion);

		JButton btnLimpiar = new JButton("Nuevo");		
		btnLimpiar.setBounds(633, 46, 122, 53);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setContentAreaFilled(false);
		btnLimpiar.setOpaque(true);
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		panelClientes.add(btnLimpiar);

		JButton btnVerTodo = new JButton("Ver Todo");
		btnVerTodo.setBounds(633, 124, 122, 53);
		btnVerTodo.setForeground(Color.WHITE);
		btnVerTodo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVerTodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerTodo.setContentAreaFilled(false);
		btnVerTodo.setOpaque(true);
		btnVerTodo.setBorder(null);
		btnVerTodo.setBackground(Color.LIGHT_GRAY);
		panelClientes.add(btnVerTodo);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(633, 189, 122, 53);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setOpaque(true);
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(Color.LIGHT_GRAY);
		panelClientes.add(btnAgregar);

		JButton btnEditar = new JButton("Editar");		
		btnEditar.setBounds(633, 253, 122, 53);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setOpaque(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(Color.LIGHT_GRAY);
		panelClientes.add(btnEditar);

		JButton btnBuscar = new JButton("Buscar");		
		btnBuscar.setBounds(633, 317, 122, 53);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		panelClientes.add(btnBuscar);

		JButton btnEliminar = new JButton("Eliminar");
		
		btnEliminar.setBounds(633, 381, 122, 53);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		panelClientes.add(btnEliminar);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(109, 11, 78, 14);
		panelClientes.add(lblClientes);

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarCliente();
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCliente();
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCliente();
			}
		});
		
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
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarCliente();
			}
		});
		
		tblCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tblCliente.getSelectedRow();
				
				if (fila != -1) {
					String dni = tblCliente.getValueAt(fila, 2).toString();
					txtDNI.setText(dni);
					buscarCliente();					
				}
			}
		});
	}
	
		protected void eliminarCliente() {
			String dni = leerDNI();
			
			if (dni != null) {
				int ok = new GestionClientes().eliminar(dni);
				
				if (ok == 0) {
					aviso("Oops algo sali� mal. No se pudo eliminar Cliente");
				} else {
					JOptionPane.showMessageDialog(this, "Se elimin� correctamente al Cliente");
					limpiar();					
					listado();
				}
			}
		
	}

		void listado() {
		ArrayList<Cliente> lista = new GestionClientes().listado();
		
		if (lista == null){
			JOptionPane.showMessageDialog(this, "Listado vacio");
		} else{
			model.setRowCount(0);
			for (Cliente c : lista){
				insertarNuevaFila(c);				
			}
		}
	}

	private void buscarCliente() {
		String dni = leerDNI();
		
		if (dni != null) {
			Cliente cliente = new GestionClientes().buscar(dni);
			
			if (cliente == null) {
				aviso("Oops no se pudo encontrar Cliente");
			} else {
				txtNombres.setText(cliente.getNom_cli());
				txtApellidos.setText(cliente.getApe_cli());
				txtTelefono.setText(cliente.getTelef_cli());
				txtDireccion.setText(cliente.getDirec_cli());
			}
		}
	}
	
	private void editarCliente() {
		Cliente cliente = crearCliente();
		
		if (cliente != null) {
			int ok = new GestionClientes().actualizar(cliente);
			
			if (ok == 0) {
				aviso("Oops no se pudo actualizar Cliente");
			} else {
				JOptionPane.showMessageDialog(this, "El cliente ah sido actualizado exitosamente");
				listado();
			}
		}
	}
		
	private void registrarCliente(){
		Cliente cliente = crearCliente();
		if (cliente != null) {
			int ok = new GestionClientes().registrar(cliente);
			
			if (ok == 0) {
				aviso("Oops algo sali� mal. No se pudo registrar Cliente");
			} else {
				JOptionPane.showMessageDialog(this, "Nuevo Cliente registrado");
				limpiar();
				listado();
				
			}
		}
		
	}

	private void insertarNuevaFila(Cliente cliente) {
		Object datos[] = {cliente.getNom_cli(), cliente.getApe_cli(), cliente.getDni_cli(), cliente.getDirec_cli(), cliente.getTelef_cli()};
		model.addRow(datos);
		
	}

	private Cliente crearCliente() {
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
							return new Cliente (0, dni, nombre, apellido, direccion, telefono);							
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
			aviso("El campo DNI est� vac�o");
			return null;
		}

		if (!dni.matches("^[0-9]{8}$")) {
			aviso("Ingrese un DNI v�lido");
			return null;
		}

		return dni;

	}

	private String leerNombre() {
		String nombre = txtNombres.getText().trim();

		if (nombre.isEmpty()) {
			aviso("El campo nombre est� vac�o");
			return null;
		}

		if (!nombre.matches("^(?=.{3,15}$)[A-Z�����a-z������]+(?:\\s[A-Z�����a-z������]+)?$")) {
			aviso("Ingrese un nombre v�lido");
			return null;
		}

		return nombre;

	}

	private String leerApellido() {
		String apellido = txtApellidos.getText().trim();

		if (apellido.isEmpty()) {
			aviso("El campo apellido est� vac�o");
			return null;
		}

		if (!apellido.matches("^(?=.{3,15}$)[A-Z�����a-z������]+(?:\\s[A-Z�����a-z������]+)?$")) {
			aviso("Ingrese un apellido v�lido");
			return null;
		}

		return apellido;
	}

	private String leerTelefono() {

		String telefono = txtTelefono.getText().trim();

		if (telefono.isEmpty()) {
			aviso("El campo Telefono est� vac�o");
			return null;
		}

		if (!telefono.matches("([0-9]{7,9})")) {
			aviso("Ingrese un tel�fono v�lido");
			return null;
		}

		return telefono;

	}

	private String leerDireccion() {
		String direccion = txtDireccion.getText().trim();
		if (direccion.isEmpty()) {
			aviso("El campo Direcci�n est� vac�o");
			return null;
		}

		return direccion;
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
