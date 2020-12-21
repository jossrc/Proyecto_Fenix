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
import javax.swing.UIManager;

public class MantClientes extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTable tblCliente;
	private DefaultTableModel model;
	private String accionBtn = "nuevo";
	private boolean deseaBuscar = true;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JButton btnEditar;
	private JButton btnNuevo;
	private JButton btnBuscar;
	

	public MantClientes() {
		setLayout(null);

		// Dando Forma al Panel
		JPanel panelClientes = new JPanel();
		panelClientes.setBounds(0, 0, 817, 515);
		add(panelClientes);
		panelClientes.setLayout(null);

		JPanel pDatosCliente = new JPanel();
		pDatosCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Personal del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(312, 21, 91, 28);
		pDatosCliente.add(btnNuevo);
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setContentAreaFilled(false);
		btnNuevo.setOpaque(true);
		btnNuevo.setBorder(null);
		btnNuevo.setBackground(new Color(35, 178, 220));

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(423, 21, 91, 28);
		pDatosCliente.add(btnEditar);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setOpaque(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(35, 178, 220));

		btnBuscar = new JButton("Buscar");
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

		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(455, 204, 91, 28);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setOpaque(true);
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(126, 171, 162));
		panelClientes.add(btnGuardar);

		btnEliminar = new JButton("Eliminar");

		btnEliminar.setBounds(576, 204, 91, 28);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(241, 71, 38));
		panelClientes.add(btnEliminar);

		btnCancelar = new JButton("Cancelar");		
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(211, 220, 35));
		btnCancelar.setBounds(694, 204, 91, 28);
		panelClientes.add(btnCancelar);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				habilitarBtnGuardar();				
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
				habilitarBtnBuscar();
			}
		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBtnEditar();
				btnGuardar.setEnabled(true);
				btnGuardar.setBackground(new Color(9, 168, 136));
				btnEliminar.setEnabled(false);
				btnEliminar.setBackground(new Color(232,169,156));
			}
		});

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activarBtnNuevo();
				btnGuardar.setEnabled(true);
				btnGuardar.setBackground(new Color(9, 168, 136));
				btnEliminar.setEnabled(false);
				btnEliminar.setBackground(new Color(232,169,156));
				btnEditar.setEnabled(false);
				btnEditar.setBackground(new Color(147,200,215));
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activarBtnCancelar();
				
				deseaBuscar = true;
				btnBuscar.setForeground(Color.WHITE);
				
				btnGuardar.setEnabled(false);
				btnGuardar.setBackground(new Color(126, 171, 162));
				btnEliminar.setEnabled(true);
				btnEliminar.setBackground(new Color(241, 71, 38));
				btnEditar.setEnabled(true);
				btnEditar.setBackground(new Color(35, 178, 220));
				btnNuevo.setEnabled(true);
				btnNuevo.setBackground(new Color(35, 178, 220));
			}
		});
		
	}
	
	/*
	 * AFTER
	 * 
	 * */
	
	
	private void habilitarBtnGuardar() {
		if (accionBtn.equals("nuevo")) {
			registrarCliente();			
		} else {
			editarCliente();
		}
	}
	
	
	private void habilitarBtnBuscar() {
	
		if (deseaBuscar) {
			activarTodosTxt(false);
			txtDNI.setEditable(true);
			
			
			btnBuscar.setForeground(Color.BLUE);
			
			// COLORES DESHABILITAR
			
			btnGuardar.setEnabled(false);
			btnGuardar.setBackground(new Color(126, 171, 162));
			btnEliminar.setEnabled(false);
			btnEliminar.setBackground(new Color(232,169,156));
			btnNuevo.setEnabled(false);
			btnNuevo.setBackground(new Color(147,200,215));
			btnEditar.setEnabled(false);
			btnEditar.setBackground(new Color(147,200,215));
			
			deseaBuscar = false;
		} else {
			buscarCliente();
			activarTodosTxt(false);
			
			btnBuscar.setForeground(Color.WHITE);
			
			// COLORES HABILITAR
			
			btnEliminar.setEnabled(true);
			btnEliminar.setBackground(new Color(241, 71, 38));
			btnNuevo.setEnabled(true);
			btnNuevo.setBackground(new Color(35, 178, 220));
			btnEditar.setEnabled(true);
			btnEditar.setBackground(new Color(35, 178, 220));
			
			deseaBuscar = true;
		}
		
	}
	
	
	private void habilitarBtnEditar() {
		accionBtn = "editar";
		activarTodosTxt(true);
		txtDNI.setEditable(false);
		
	}
	
	private void activarBtnCancelar() {
		activarTodosTxt(false);
		
		accionBtn = "nuevo";
	}
	
	private void activarBtnNuevo() {
		activarTodosTxt(true);		
		limpiar();
	}
	
	private void activarTodosTxt(boolean activar) {
		txtDNI.setEditable(activar);
		activarTxt(txtNombres, activar);
		activarTxt(txtApellidos, activar);
		activarTxt(txtTelefono, activar);
		activarTxt(txtDireccion, activar);
	}
	
	private void activarTxt(JTextField txt, boolean activar) {
		txt.setEnabled(activar);
		txt.setEditable(activar);
	}
	
	/*
	 * BEFORE
	 * 
	 * */

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
				
				// COLORES
				
				activarTodosTxt(false);
				
				btnGuardar.setEnabled(false);
				btnGuardar.setBackground(new Color(126, 171, 162));
				btnEliminar.setEnabled(true);
				btnEliminar.setBackground(new Color(241, 71, 38));
				btnEditar.setEnabled(true);
				btnEditar.setBackground(new Color(35, 178, 220));
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
				
				// COLORES
				
				activarTodosTxt(false);
				
				btnGuardar.setEnabled(false);
				btnGuardar.setBackground(new Color(126, 171, 162));
				btnEliminar.setEnabled(true);
				btnEliminar.setBackground(new Color(241, 71, 38));
				btnEditar.setEnabled(true);
				btnEditar.setBackground(new Color(35, 178, 220));

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

		if (!nombre.matches("^(?=.{3,45}$)[A-ZÁÉÍÓÚa-zñáéíóú]+(?:\\s[A-ZÁÉÍÓÚa-zñáéíóú]+)?$")) {
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

		if (!apellido.matches("^(?=.{3,45}$)[A-ZÁÉÍÓÚa-zñáéíóú]+(?:\\s[A-ZÁÉÍÓÚa-zñáéíóú]+)?$")) {
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
