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

	public MantProducto() {
		setLayout(null);

		JPanel panelProducto = new JPanel();
		panelProducto.setBounds(0, 0, 817, 515);
		add(panelProducto);
		panelProducto.setLayout(null);

		JLabel lblCodigo = new JLabel("C�digo");
		lblCodigo.setBounds(37, 45, 46, 14);
		panelProducto.add(lblCodigo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 243, 771, 211);
		panelProducto.add(scrollPane);

		tblProducto = new JTable();		
		model = new DefaultTableModel();
		tblProducto.setModel(model);
		scrollPane.setViewportView(tblProducto);
		model.addColumn("C�digo");
		model.addColumn("Descripci�n");
		model.addColumn("Marca");
		model.addColumn("Tipo");
		model.addColumn("Stock");
		model.addColumn("Precio");

		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(37, 71, 62, 14);
		panelProducto.add(lblDescripcion);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(37, 136, 26, 14);
		panelProducto.add(lblStock);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(37, 100, 46, 14);
		panelProducto.add(lblMarca);

		txtCodigo = new JTextField();
		txtCodigo.setForeground(Color.BLUE);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(109, 42, 174, 20);
		txtCodigo.setText(generarCodigoProducto());
		panelProducto.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setEnabled(false);
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(109, 71, 542, 20);		
		txtDescripcion.setColumns(10);
		panelProducto.add(txtDescripcion);

		txtStock = new JTextField();
		txtStock.setEnabled(false);
		txtStock.setEditable(false);
		txtStock.setBounds(109, 133, 195, 20);
		txtStock.setColumns(10);
		panelProducto.add(txtStock);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(317, 36, 91, 28);
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setContentAreaFilled(false);
		btnNuevo.setOpaque(true);
		btnNuevo.setBorder(null);
		btnNuevo.setBackground(new Color(35, 178, 220));
		panelProducto.add(btnNuevo);

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

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(455, 204, 91, 28);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setOpaque(true);
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(126, 171, 162));
		panelProducto.add(btnGuardar);

		JButton btnEditar = new JButton("Editar");		
		btnEditar.setBounds(435, 36, 91, 28);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setOpaque(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(35, 178, 220));
		panelProducto.add(btnEditar);

		JButton btnBuscar = new JButton("Buscar");		
		btnBuscar.setBounds(556, 36, 91, 28);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(35, 178, 220));
		panelProducto.add(btnBuscar);

		JButton btnEliminar = new JButton("Eliminar");		
		btnEliminar.setBounds(576, 204, 91, 28);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(241, 71, 38));
		panelProducto.add(btnEliminar);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(339, 100, 46, 14);
		panelProducto.add(lblTipo);

		cboTipo = new JComboBox<String>();
		cboTipo.setEnabled(false);
		cboTipo.setBounds(406, 98, 195, 20);
		panelProducto.add(cboTipo);

		cboMarca = new JComboBox<String>();
		cboMarca.setEnabled(false);
		cboMarca.setBounds(109, 98, 195, 20);
		panelProducto.add(cboMarca);

		JLabel lblPrecioUnit = new JLabel("Precio Unit.");
		lblPrecioUnit.setBounds(339, 136, 55, 14);
		panelProducto.add(lblPrecioUnit);

		txtPrecioUnit = new JTextField();
		txtPrecioUnit.setEnabled(false);
		txtPrecioUnit.setEditable(false);
		txtPrecioUnit.setColumns(10);
		txtPrecioUnit.setBounds(406, 133, 195, 20);
		panelProducto.add(txtPrecioUnit);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(211, 220, 35));
		btnCancelar.setBounds(694, 204, 91, 28);
		panelProducto.add(btnCancelar);
				
		llenarCboMarca();
		llenarCboTipos();

		btnVerTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				txtCodigo.setText(generarCodigoProducto());
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarProducto();
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarProducto();
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProducto();
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarProducto();
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
	
	protected void listado() {
		ArrayList<ReporteProducto> lista = new GestionReporteProducto().listado();
		
		if (lista == null){
			JOptionPane.showMessageDialog(this, "Listado vacio");
		} else{
			model.setRowCount(0);
			for (ReporteProducto r : lista){
				insertarNuevaFila(r);				
			}
		}
		
	}

	private void insertarNuevaFila(ReporteProducto r) {
		Object datos[] = {r.getCodigo(), r.getDescripcion(), r.getMarca(), r.getTipo(), r.getStock(), r.getPrecio()};
		model.addRow(datos);
	}

	private void registrarProducto() {
		Producto producto = crearProducto();
		
		if (producto != null) {
			int ok = new GestionProductos().registrar(producto);
			
			if (ok == 0) {
				aviso("Oops algo sali� mal. No se pudo registrar Producto");
			} else {
				JOptionPane.showMessageDialog(this, "Nuevo Producto registrado");
				limpiar();
				txtCodigo.setText(generarCodigoProducto());
				listado();
			}
		}
		
	}
	
	private void actualizarProducto() {
		Producto producto = crearProducto();
		
		if (producto != null) {
			int ok = new GestionProductos().actualizar(producto);
			
			if (ok == 0) {
				aviso("Oops algo sali� mal. No se pudo actualizar Producto");
			} else {
				JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
				limpiar();
				txtCodigo.setText(generarCodigoProducto());
				listado();
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
				txtStock.setText(p.getStock()+"");
				txtPrecioUnit.setText(p.getPrecioUnitario()+"");	
			}
		}
	}
	
	private void eliminarProducto() {
		String codigo = leerCodigo();
		
		if (codigo != null) {
			int ok = new GestionProductos().eliminar(codigo);
			
			if (ok == 0) {
				aviso("Oops algo sali� mal. No se pudo eliminar producto");
			} else {
				JOptionPane.showMessageDialog(this, "Se elimin� correctamente el producto");
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
				cboMarca.addItem(marca.getIdMarca()+".- " + marca.getDescripcion());
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
				cboTipo.addItem(tipo.getIdTipo()+".- " + tipo.getDescripcion());
			}
		}
	}
	
	private String generarCodigoProducto() {
		return new GestionProductos().generarCodigo();
	}

	private String leerCodigo() {
		String codigo = txtCodigo.getText().toUpperCase().trim();

		if (codigo.isEmpty()) {
			aviso("El campo C�digo est� vac�o");
			return null;
		}

		if (!codigo.matches("PROD[0-9]{4}")) {
			aviso("Ingrese un c�digo v�lido (PRODXXXX)");
			return null;
		}

		return codigo;
	}

	private String leerDescripcion() {
		String descripcion = txtDescripcion.getText().trim();

		if (descripcion.isEmpty()) {
			aviso("El campo Descripci�n est� vac�o");
			return null;
		}

		return descripcion;
	}

	private int leerStock() {
		String stock = txtStock.getText().trim();

		if (stock.isEmpty()) {
			aviso("El campo Stock est� vac�o");
			return -1;
		}

		if (!stock.matches("[1-9]+[0-9]*")) {
			aviso("Ingrese un valor v�lido para el Stock");
			return -1;
		}

		return Integer.parseInt(stock);

	}

	private double leerPrecioUnit() {

		String precioUnit = txtPrecioUnit.getText().trim();

		if (precioUnit.isEmpty()) {
			aviso("El Campo Precio Unit. est� vac�o");
			return -1;
		}

		if (!precioUnit.matches("[0-9]+([.][0-9]{1,2})?")) {
			aviso("Ingrese un precio v�lido");
			return -1;
		}

		return Double.parseDouble(precioUnit);
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
		int tipo = cboTipo.getSelectedIndex();

		if (tipo == -1 || tipo == 0) {
			aviso("Seleccione un Tipo v�lido");
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
