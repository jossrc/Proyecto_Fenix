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
import javax.swing.border.TitledBorder;

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

		JPanel pDatosCliente = new JPanel();
		pDatosCliente.setBorder(new TitledBorder(null, "Informaci\u00F3n Personal", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pDatosCliente.setBounds(21, 9, 771, 176);
		panelClientes.add(pDatosCliente);
		pDatosCliente.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(21, 58, 46, 14);
		pDatosCliente.add(lblNombres);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(21, 83, 46, 14);
		pDatosCliente.add(lblApellidos);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(21, 30, 46, 14);
		pDatosCliente.add(lblDni);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(21, 111, 46, 14);
		pDatosCliente.add(lblTelefono);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(21, 136, 46, 14);
		pDatosCliente.add(lblDireccin);

		txtNombres = new JTextField();
		txtNombres.setEnabled(false);
		txtNombres.setEditable(false);
		txtNombres.setBounds(93, 55, 542, 20);
		pDatosCliente.add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setEnabled(false);
		txtApellidos.setEditable(false);
		txtApellidos.setBounds(93, 80, 542, 20);
		pDatosCliente.add(txtApellidos);
		txtApellidos.setColumns(10);

		txtDNI = new JTextField();
		txtDNI.setForeground(Color.BLUE);
		txtDNI.setEditable(false);
		txtDNI.setBounds(93, 27, 174, 20);
		pDatosCliente.add(txtDNI);
		txtDNI.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(93, 108, 174, 20);
		pDatosCliente.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(93, 133, 323, 20);
		pDatosCliente.add(txtDireccion);
		txtDireccion.setColumns(10);

		JButton btnLimpiar = new JButton("Nuevo");
		btnLimpiar.setBounds(312, 21, 91, 28);
		pDatosCliente.add(btnLimpiar);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setContentAreaFilled(false);
		btnLimpiar.setOpaque(true);
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(new Color(35, 178, 220));

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(423, 21, 91, 28);
		pDatosCliente.add(btnEditar);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setOpaque(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(35, 178, 220));

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(544, 21, 91, 28);
		pDatosCliente.add(btnBuscar);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(35, 178, 220));		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 243, 771, 211);
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

		JButton btnVerTodo = new JButton("Ver Todo");
		btnVerTodo.setBounds(677, 465, 115, 28);
		btnVerTodo.setForeground(Color.WHITE);
		btnVerTodo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVerTodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerTodo.setContentAreaFilled(false);
		btnVerTodo.setOpaque(true);
		btnVerTodo.setBorder(null);
		btnVerTodo.setBackground(Color.GRAY);
		panelClientes.add(btnVerTodo);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(455, 204, 91, 28);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setOpaque(true);
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(new Color(9, 168, 136));
		panelClientes.add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");

		btnEliminar.setBounds(576, 204, 91, 28);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(241, 71, 38));
		panelClientes.add(btnEliminar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(211, 220, 35));
		btnCancelar.setBounds(694, 204, 91, 28);
		panelClientes.add(btnCancelar);

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarCliente();
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
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCliente();
			}
		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCliente();
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
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

		if (lista == null) {
			JOptionPane.showMessageDialog(this, "Listado vacio");
		} else {
			model.setRowCount(0);
			for (Cliente c : lista) {
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

	private void registrarCliente() {
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
		Object datos[] = { cliente.getNom_cli(), cliente.getApe_cli(), cliente.getDni_cli(), cliente.getDirec_cli(),
				cliente.getTelef_cli() };
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
							return new Cliente(0, dni, nombre, apellido, direccion, telefono);
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
