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

		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(37, 45, 46, 14);
		panelProducto.add(lblCodigo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 600, 271);
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

		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(37, 70, 62, 14);
		panelProducto.add(lblDescripcion);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(37, 163, 26, 14);
		panelProducto.add(lblStock);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(37, 101, 46, 14);
		panelProducto.add(lblMarca);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(109, 42, 323, 20);
		txtCodigo.setText(generarCodigoProducto());
		panelProducto.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(109, 67, 323, 20);		
		txtDescripcion.setColumns(10);
		panelProducto.add(txtDescripcion);

		txtStock = new JTextField();
		txtStock.setBounds(109, 160, 115, 20);
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
		lblTipo.setBounds(37, 126, 46, 14);
		panelProducto.add(lblTipo);

		cboTipo = new JComboBox<String>();
		cboTipo.setBounds(109, 129, 323, 20);
		panelProducto.add(cboTipo);

		cboMarca = new JComboBox<String>();
		cboMarca.setBounds(109, 98, 323, 20);
		panelProducto.add(cboMarca);

		JLabel lblPrecioUnit = new JLabel("Precio Unit.");
		lblPrecioUnit.setBounds(249, 163, 55, 14);
		panelProducto.add(lblPrecioUnit);

		txtPrecioUnit = new JTextField();
		txtPrecioUnit.setColumns(10);
		txtPrecioUnit.setBounds(317, 160, 115, 20);
		panelProducto.add(txtPrecioUnit);
				
		llenarCboMarca();
		llenarCboTipos();

		btnVerTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				txtCodigo.setText(generarCodigoProducto());
			}
		});

		btnAgregar.addActionListener(new ActionListener() {
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
				aviso("Oops algo salió mal. No se pudo registrar Producto");
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
				aviso("Oops algo salió mal. No se pudo actualizar Producto");
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
