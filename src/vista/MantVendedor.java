package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionVendedores;
import model.Vendedor;

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

public class MantVendedor extends JPanel {
	
private static final long serialVersionUID = 1L;
	
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTable tblVendedor;
	private DefaultTableModel model;
	private String accionBtn = "nuevo";
	private boolean deseaBuscar = true;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JButton btnEditar;
	private JButton btnNuevo;
	private JButton btnBuscar;

	
	public MantVendedor() {
		setLayout(null);
		
		//Dando Forma al Panel
		JPanel panelVendedor = new JPanel();
		panelVendedor.setBounds(0, 0, 817, 515);
		add(panelVendedor);
		panelVendedor.setLayout(null);
		
		JPanel pDatosVendedor = new JPanel();
		pDatosVendedor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Personal del Vendedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pDatosVendedor.setBounds(21, 9, 771, 176);
		panelVendedor.add(pDatosVendedor);
		pDatosVendedor.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(21, 58, 46, 14);
		pDatosVendedor.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(21, 83, 46, 14);
		pDatosVendedor.add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(21, 30, 46, 14);
		pDatosVendedor.add(lblDni);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(21, 111, 46, 14);
		pDatosVendedor.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(21, 136, 46, 14);
		pDatosVendedor.add(lblDireccion);
		
		txtNombres = new JTextField();
		txtNombres.setEnabled(false);
		txtNombres.setEditable(false);
		txtNombres.setBounds(93, 55, 542, 20);
		pDatosVendedor.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setEnabled(false);
		txtApellidos.setEditable(false);
		txtApellidos.setBounds(93, 80, 542, 20);
		pDatosVendedor.add(txtApellidos);
		txtApellidos.setColumns(10);

		txtDNI = new JTextField();
		txtDNI.setForeground(Color.BLUE);
		txtDNI.setEditable(false);
		txtDNI.setBounds(93, 27, 174, 20);
		pDatosVendedor.add(txtDNI);
		txtDNI.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(93, 108, 174, 20);
		pDatosVendedor.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(93, 133, 323, 20);
		pDatosVendedor.add(txtDireccion);
		txtDireccion.setColumns(10);

		
		JButton btnVerTodo = new JButton("Ver Todo");
		btnVerTodo.setBounds(677, 465, 115, 28);
		btnVerTodo.setForeground(Color.WHITE);
		btnVerTodo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVerTodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerTodo.setContentAreaFilled(false);
		btnVerTodo.setOpaque(true);
		btnVerTodo.setBorder(null);
		btnVerTodo.setBackground(Color.GRAY);
		panelVendedor.add(btnVerTodo);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(325, 21, 91, 28);
		pDatosVendedor.add(btnNuevo);
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setContentAreaFilled(false);
		btnNuevo.setOpaque(true);
		btnNuevo.setBorder(null);
		btnNuevo.setBackground(new Color(35, 178, 220));
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(430, 21, 91, 28);
		pDatosVendedor.add(btnEditar);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setOpaque(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(35, 178, 220));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 243, 771, 211);
		panelVendedor.add(scrollPane);
		
		tblVendedor = new JTable();		
		model = new DefaultTableModel();
		tblVendedor.setModel(model);
		scrollPane.setViewportView(tblVendedor);
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Dirección");
		model.addColumn("Teléfono");	
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(544, 21, 91, 28);
		pDatosVendedor.add(btnBuscar);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(35, 178, 220));	
		
		btnEliminar = new JButton("Eliminar");

		btnEliminar.setBounds(576, 204, 91, 28);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(241, 71, 38));
		panelVendedor.add(btnEliminar);
		
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
		panelVendedor.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");		
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(211, 220, 35));
		btnCancelar.setBounds(694, 204, 91, 28);
		panelVendedor.add(btnCancelar);
		
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
				eliminarVendedor();
			}
		});

		tblVendedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tblVendedor.getSelectedRow();

				if (fila != -1) {
					String dni = tblVendedor.getValueAt(fila, 2).toString();
					txtDNI.setText(dni);
					buscarVendedor();
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
			registrarVendedor();			
		} else {
			editarVendedor();
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
			buscarVendedor();
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

	protected void eliminarVendedor() {
		String dni = leerDNI();

		if (dni != null) {
			int ok = new GestionVendedores().eliminar(dni);

			if (ok == 0) {
				aviso("Oops algo salió mal. No se pudo eliminar Vendedor");
			} else {
				JOptionPane.showMessageDialog(this, "Se eliminó correctamente al Vendedor");
				limpiar();
				listado();
			}
		}

	}

	void listado() {
		ArrayList<Vendedor> lista = new GestionVendedores().listado();

		if (lista == null) {
			JOptionPane.showMessageDialog(this, "Listado vacio");
		} else {
			model.setRowCount(0);
			for (Vendedor v : lista) {
				insertarNuevaFila(v);
			}
		}
	}

	private void buscarVendedor() {
		String dni = leerDNI();

		if (dni != null) {
			Vendedor vendedor = new GestionVendedores().buscar(dni);

			if (vendedor == null) {
				aviso("Oops no se pudo encontrar Vendedor");
			} else {
				txtNombres.setText(vendedor.getNombre());
				txtApellidos.setText(vendedor.getApellido());
				txtTelefono.setText(vendedor.getTelefono());
				txtDireccion.setText(vendedor.getDireccion());
			}
		}
	}

	private void editarVendedor() {
		Vendedor vendedor = crearVendedor();

		if (vendedor != null) {
			int ok = new GestionVendedores().actualizar(vendedor);

			if (ok == 0) {
				aviso("Oops no se pudo actualizar Vendedor");
			} else {
				JOptionPane.showMessageDialog(this, "El vendedor ha sido actualizado exitosamente");
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

	private void registrarVendedor() {
		Vendedor vendedor = crearVendedor();
		if (vendedor != null) {
			int ok = new GestionVendedores().registrar(vendedor);

			if (ok == 0) {
				aviso("Oops algo salió mal. No se pudo registrar Vendedor");
			} else {
				JOptionPane.showMessageDialog(this, "Nuevo Vendedor registrado");
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

	private void insertarNuevaFila(Vendedor vendedor) {
		Object datos[] = { vendedor.getNombre(), vendedor.getApellido(), vendedor.getDni(), vendedor.getDireccion(),
				vendedor.getTelefono() };
		model.addRow(datos);

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
