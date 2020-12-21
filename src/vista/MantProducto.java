package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionMarcaProducto;
import mantenimientos.GestionProductos;
import mantenimientos.GestionReporteProducto;
import mantenimientos.GestionTipoProducto;

import model.MarcaProducto;
import model.Producto;
import model.ReporteProducto;
import model.TipoProducto;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;

public class MantProducto extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtStock;

	private JTable tblProducto;
	private JComboBox<String> cboMarca;
	private JComboBox<String> cboTipo;
	private JTextField txtPrecioUnit;
	private DefaultTableModel model;

	// Global
	private String accionBtn = "nuevo";
	private boolean deseaBuscar = true;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnBuscar;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	
	public MantProducto() {
		setLayout(null);

		JPanel panelProducto = new JPanel();
		panelProducto.setBounds(0, 0, 817, 515);
		add(panelProducto);
		panelProducto.setLayout(null);

		JPanel pDatosProducto = new JPanel();
		pDatosProducto.setBorder(new TitledBorder(null, "Informaci\u00F3n del Producto", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pDatosProducto.setBounds(21, 11, 771, 158);
		panelProducto.add(pDatosProducto);
		pDatosProducto.setLayout(null);

		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(21, 30, 46, 14);
		pDatosProducto.add(lblCodigo);

		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(21, 64, 62, 14);
		pDatosProducto.add(lblDescripcion);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(21, 114, 26, 14);
		pDatosProducto.add(lblStock);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(21, 89, 46, 14);
		pDatosProducto.add(lblMarca);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(100, 30, 174, 20);
		pDatosProducto.add(txtCodigo);
		txtCodigo.setForeground(Color.BLUE);
		txtCodigo.setEditable(false);
		txtCodigo.setText(generarCodigoProducto());
		txtCodigo.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(100, 61, 527, 20);
		pDatosProducto.add(txtDescripcion);
		txtDescripcion.setEnabled(false);
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);

		txtStock = new JTextField();
		txtStock.setBounds(100, 111, 195, 20);
		pDatosProducto.add(txtStock);
		txtStock.setEnabled(false);
		txtStock.setEditable(false);
		txtStock.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(294, 24, 91, 28);
		pDatosProducto.add(btnNuevo);
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setContentAreaFilled(false);
		btnNuevo.setOpaque(true);
		btnNuevo.setBorder(null);
		btnNuevo.setBackground(new Color(35, 178, 220));

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(415, 24, 91, 28);
		pDatosProducto.add(btnEditar);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setOpaque(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(35, 178, 220));

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(536, 24, 91, 28);
		pDatosProducto.add(btnBuscar);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(35, 178, 220));

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(330, 88, 46, 14);
		pDatosProducto.add(lblTipo);

		cboTipo = new JComboBox<String>();
		cboTipo.setBounds(397, 85, 195, 20);
		pDatosProducto.add(cboTipo);
		cboTipo.setEnabled(false);

		cboMarca = new JComboBox<String>();
		cboMarca.setBounds(100, 85, 195, 20);
		pDatosProducto.add(cboMarca);
		cboMarca.setEnabled(false);

		JLabel lblPrecioUnit = new JLabel("Precio Unit.");
		lblPrecioUnit.setBounds(330, 113, 55, 14);
		pDatosProducto.add(lblPrecioUnit);

		txtPrecioUnit = new JTextField();
		txtPrecioUnit.setBounds(397, 111, 195, 20);
		pDatosProducto.add(txtPrecioUnit);
		txtPrecioUnit.setEnabled(false);
		txtPrecioUnit.setEditable(false);
		txtPrecioUnit.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 227, 771, 227);
		panelProducto.add(scrollPane);

		tblProducto = new JTable();
		model = new DefaultTableModel();
		tblProducto.setModel(model);
		scrollPane.setViewportView(tblProducto);
		model.addColumn("Código");
		model.addColumn("Descripción");
		model.addColumn("Marca");
		model.addColumn("Tipo");
		model.addColumn("Stock");
		model.addColumn("Precio");

		JButton btnVerTodo = new JButton("Ver Todo");
		btnVerTodo.setBounds(677, 465, 115, 28);
		btnVerTodo.setForeground(Color.WHITE);
		btnVerTodo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVerTodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerTodo.setContentAreaFilled(false);
		btnVerTodo.setOpaque(true);
		btnVerTodo.setBorder(null);
		btnVerTodo.setBackground(Color.GRAY);
		panelProducto.add(btnVerTodo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(452, 188, 91, 28);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setOpaque(true);
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(126, 171, 162));
		panelProducto.add(btnGuardar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(573, 188, 91, 28);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(241, 71, 38));
		panelProducto.add(btnEliminar);

		btnCancelar = new JButton("Cancelar");		
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(211, 220, 35));
		btnCancelar.setBounds(691, 188, 91, 28);
		panelProducto.add(btnCancelar);

		llenarCboMarca();
		llenarCboTipos();
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//buscarProducto();
				habilitarBtnBuscar();
			}
		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// actualizarProducto();
				habilitarBtnEditar();			
				
				btnGuardar.setEnabled(true);
				btnGuardar.setBackground(new Color(9, 168, 136));
				btnEliminar.setEnabled(false);
				btnEliminar.setBackground(new Color(232,169,156));
			}
		});

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBtnNuevo();
				txtCodigo.setText(generarCodigoProducto());
				
				btnGuardar.setEnabled(true);
				btnGuardar.setBackground(new Color(9, 168, 136));
				btnEliminar.setEnabled(false);
				btnEliminar.setBackground(new Color(232,169,156));
				btnEditar.setEnabled(false);
				btnEditar.setBackground(new Color(147,200,215));
			}
		});

		btnVerTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//registrarProducto();
				habilitarBtnGuardar();
			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarProducto();
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

		tblProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = tblProducto.getSelectedRow();

				if (fila != -1) {
					String codigo = tblProducto.getValueAt(fila, 0).toString();

					txtCodigo.setText(codigo);
					buscarProducto();
				}
			}
		});

	}
	
	
	/*
	 * AFTER
	 * 
	 * */
	
	private void habilitarBtnGuardar() {
		if (accionBtn.equals("nuevo")) {
			registrarProducto();	
		} else {
			actualizarProducto();
		}
	}
	
	
	private void habilitarBtnBuscar() {
		
		if (deseaBuscar) {
			activarTodosTxtCbo(false);
			txtCodigo.setText("");
			
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
			buscarProducto();
			activarTodosTxtCbo(false);
			txtCodigo.setEditable(false);
			
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
		activarTodosTxtCbo(true);
	}
	
	private void activarBtnCancelar() {
		activarTodosTxtCbo(false);		
		accionBtn = "nuevo";
		txtCodigo.setEditable(false);
	}
	
	private void habilitarBtnNuevo() {
		activarTodosTxtCbo(true);
		limpiar();
	}
	
	private void activarTodosTxtCbo(boolean activar) {
		txtCodigo.setEditable(!activar); // Reverse
		activarTxt(txtDescripcion, activar);
		activarCbo(cboMarca, activar);
		activarCbo(cboTipo, activar);
		activarTxt(txtStock, activar);
		activarTxt(txtPrecioUnit, activar);
	}
	
	private void activarTxt(JTextField txt, boolean activar) {
		txt.setEnabled(activar);
		txt.setEditable(activar);
	}
	
	private void activarCbo(JComboBox<String> cbo, boolean activar) {
		cbo.setEnabled(activar);
		cbo.setEnabled(activar);
	}
	
	
	/*
	 * BEFORE
	 * 
	 * */

	protected void listado() {
		ArrayList<ReporteProducto> lista = new GestionReporteProducto().listado();

		if (lista == null) {
			JOptionPane.showMessageDialog(this, "Listado vacio");
		} else {
			model.setRowCount(0);
			for (ReporteProducto r : lista) {
				insertarNuevaFila(r);
			}
		}

	}

	private void insertarNuevaFila(ReporteProducto r) {
		Object datos[] = { r.getCodigo(), r.getDescripcion(), r.getMarca(), r.getTipo(), r.getStock(), r.getPrecio() };
		model.addRow(datos);
	}

	private void registrarProducto() {
		Producto producto = crearProducto();

		if (producto != null) {
			int ok = new GestionProductos().registrar(producto);

			if (ok == 0) {
				aviso("Oops algo salió mal. No se pudo registrar Producto");
			} else {
				JOptionPane.showMessageDialog(this, "Nuevo Producto registrado");
				limpiar();
				txtCodigo.setText(generarCodigoProducto());
				listado();
				
				activarTodosTxtCbo(false);
				txtCodigo.setEditable(false);
				
				btnGuardar.setEnabled(false);
				btnGuardar.setBackground(new Color(126, 171, 162));
				btnEliminar.setEnabled(true);
				btnEliminar.setBackground(new Color(241, 71, 38));
				btnEditar.setEnabled(true);
				btnEditar.setBackground(new Color(35, 178, 220));
			}
		}

	}

	private void actualizarProducto() {
		Producto producto = crearProducto();

		if (producto != null) {
			int ok = new GestionProductos().actualizar(producto);

			if (ok == 0) {
				aviso("Oops algo salió mal. No se pudo actualizar Producto");
			} else {
				JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
				limpiar();
				txtCodigo.setText(generarCodigoProducto());
				listado();
				
				activarTodosTxtCbo(false);
				txtCodigo.setEditable(false);
				
				btnGuardar.setEnabled(false);
				btnGuardar.setBackground(new Color(126, 171, 162));
				btnEliminar.setEnabled(true);
				btnEliminar.setBackground(new Color(241, 71, 38));
				btnEditar.setEnabled(true);
				btnEditar.setBackground(new Color(35, 178, 220));
				
			}
		}
	}

	private void buscarProducto() {
		String codigo = leerCodigo();

		if (codigo != null) {

			Producto p = new GestionProductos().buscar(codigo);

			if (p == null) {
				aviso("Oops no se pudo encontrar Producto");
			} else {
				txtCodigo.setText(p.getCodigo());
				txtDescripcion.setText(p.getDescripcion());
				cboMarca.setSelectedIndex(p.getIdMarca());
				cboTipo.setSelectedIndex(p.getIdTipo());
				txtStock.setText(p.getStock() + "");
				txtPrecioUnit.setText(p.getPrecioUnitario() + "");
			}
		}
	}

	private void eliminarProducto() {
		String codigo = leerCodigo();

		if (codigo != null) {
			int ok = new GestionProductos().eliminar(codigo);

			if (ok == 0) {
				aviso("Oops algo salió mal. No se pudo eliminar producto");
			} else {
				JOptionPane.showMessageDialog(this, "Se eliminó correctamente el producto");
				limpiar();
				txtCodigo.setText(generarCodigoProducto());
				listado();
			}
		}

	}

	private Producto crearProducto() {
		String codigo = leerCodigo();
		String descripcion;
		int stock, marca, tipo;
		double precioUnit;

		if (codigo != null) {
			descripcion = leerDescripcion();
			if (descripcion != null) {
				marca = leerMarca();
				if (marca != -1) {
					tipo = leerTipo();
					if (tipo != -1) {
						stock = leerStock();
						if (stock != -1) {
							precioUnit = leerPrecioUnit();
							if (precioUnit != -1) {
								return new Producto(codigo, descripcion, marca, tipo, stock, precioUnit);
							}
						}
					}
				}
			}
		}

		return null;

	}

	private void llenarCboMarca() {

		cboMarca.addItem("Seleccione Marca...");
		ArrayList<MarcaProducto> lista = new GestionMarcaProducto().listado();

		if (lista == null) {
			System.out.println("Hubo un problema al cargar la lista de marcas");
		} else {
			for (MarcaProducto marca : lista) {
				cboMarca.addItem(marca.getIdMarca() + ".- " + marca.getDescripcion());
			}
		}

	}

	private void llenarCboTipos() {
		cboTipo.addItem("Seleccione Tipo...");
		ArrayList<TipoProducto> lista = new GestionTipoProducto().listado();

		if (lista == null) {
			System.out.println("Hubo un problema al cargar la lista de tipos");
		} else {
			for (TipoProducto tipo : lista) {
				cboTipo.addItem(tipo.getIdTipo() + ".- " + tipo.getDescripcion());
			}
		}
	}

	private String generarCodigoProducto() {
		return new GestionProductos().generarCodigo();
	}

	private String leerCodigo() {
		String codigo = txtCodigo.getText().toUpperCase().trim();

		if (codigo.isEmpty()) {
			aviso("El campo Código está vacío");
			return null;
		}

		if (!codigo.matches("PROD[0-9]{4}")) {
			aviso("Ingrese un código válido (PRODXXXX)");
			return null;
		}

		return codigo;
	}

	private String leerDescripcion() {
		String descripcion = txtDescripcion.getText().trim();

		if (descripcion.isEmpty()) {
			aviso("El campo Descripción está vacío");
			return null;
		}

		return descripcion;
	}

	private int leerStock() {
		String stock = txtStock.getText().trim();

		if (stock.isEmpty()) {
			aviso("El campo Stock está vacío");
			return -1;
		}

		if (!stock.matches("[1-9]+[0-9]*")) {
			aviso("Ingrese un valor válido para el Stock");
			return -1;
		}

		return Integer.parseInt(stock);

	}

	private double leerPrecioUnit() {

		String precioUnit = txtPrecioUnit.getText().trim();

		if (precioUnit.isEmpty()) {
			aviso("El Campo Precio Unit. está vacío");
			return -1;
		}

		if (!precioUnit.matches("[0-9]+([.][0-9]{1,2})?")) {
			aviso("Ingrese un precio válido");
			return -1;
		}

		return Double.parseDouble(precioUnit);
	}

	private int leerMarca() {
		int marca = cboMarca.getSelectedIndex();

		if (marca == -1 || marca == 0) {
			aviso("Seleccione una Marca válida");
			return -1;
		}

		return marca;
	}

	private int leerTipo() {
		int tipo = cboTipo.getSelectedIndex();

		if (tipo == -1 || tipo == 0) {
			aviso("Seleccione un Tipo válido");
			return -1;
		}

		return tipo;
	}

	private void aviso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Aviso", 2);
	}

	private void limpiar() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		cboMarca.setSelectedIndex(0);
		cboTipo.setSelectedIndex(0);
		txtStock.setText("");
		txtPrecioUnit.setText("");

		txtCodigo.requestFocus();
		txtCodigo.selectAll();
	}
}
