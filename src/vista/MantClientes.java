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
		panelClientes.setBounds(0, 0, 817, 515);
		add(panelClientes);
		panelClientes.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(53, 74, 46, 14);
		panelClientes.add(lblNombres);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 215, 771, 239);
		panelClientes.add(scrollPane);

		tblCliente = new JTable();		
		model = new DefaultTableModel();
		tblCliente.setModel(model);
		scrollPane.setViewportView(tblCliente);
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Dirección");
		model.addColumn("Teléfono");

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(53, 99, 46, 14);
		panelClientes.add(lblApellidos);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(53, 46, 46, 14);
		panelClientes.add(lblDni);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(53, 127, 46, 14);
		panelClientes.add(lblTelefono);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(53, 152, 46, 14);
		panelClientes.add(lblDireccin);

		txtNombres = new JTextField();
		txtNombres.setBounds(125, 71, 542, 20);
		panelClientes.add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(125, 96, 542, 20);
		txtApellidos.setColumns(10);
		panelClientes.add(txtApellidos);

		txtDNI = new JTextField();
		txtDNI.setBounds(125, 43, 174, 20);
		txtDNI.setColumns(10);
		panelClientes.add(txtDNI);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(125, 124, 174, 20);
		txtTelefono.setColumns(10);
		panelClientes.add(txtTelefono);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(125, 149, 323, 20);
		txtDireccion.setColumns(10);
		panelClientes.add(txtDireccion);

		JButton btnLimpiar = new JButton("Nuevo");		
		btnLimpiar.setBounds(344, 37, 91, 28);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setContentAreaFilled(false);
		btnLimpiar.setOpaque(true);
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(new Color(35, 178, 220));
		panelClientes.add(btnLimpiar);

		JButton btnVerTodo = new JButton("Ver Todo");
		btnVerTodo.setBounds(677, 465, 91, 28);
		btnVerTodo.setForeground(Color.WHITE);
		btnVerTodo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVerTodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerTodo.setContentAreaFilled(false);
		btnVerTodo.setOpaque(true);
		btnVerTodo.setBorder(null);
		btnVerTodo.setBackground(Color.GRAY);
		panelClientes.add(btnVerTodo);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(483, 176, 91, 28);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setOpaque(true);
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(new Color(9, 168, 136));
		panelClientes.add(btnAgregar);

		JButton btnEditar = new JButton("Editar");		
		btnEditar.setBounds(455, 37, 91, 28);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setOpaque(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(35, 178, 220));
		panelClientes.add(btnEditar);

		JButton btnBuscar = new JButton("Buscar");		
		btnBuscar.setBounds(576, 37, 91, 28);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(35, 178, 220));
		panelClientes.add(btnBuscar);

		JButton btnEliminar = new JButton("Eliminar");
		
		btnEliminar.setBounds(596, 176, 91, 28);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(241, 71, 38));
		panelClientes.add(btnEliminar);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(109, 11, 78, 14);
		panelClientes.add(lblClientes);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(211, 220, 35));
		btnCancelar.setBounds(701, 176, 91, 28);
		panelClientes.add(btnCancelar);

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
					aviso("Oops algo salió mal. No se pudo eliminar Cliente");
				} else {
					JOptionPane.showMessageDialog(this, "Se eliminó correctamente al Cliente");
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
				aviso("Oops algo salió mal. No se pudo registrar Cliente");
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
