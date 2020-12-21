package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionProductos;

import model.Producto;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DlgBuscarProducto extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tblProductos;
	private JButton btnSeleccionar;
	private DefaultTableModel model;
	
	// GLOBAL
	//public static Producto productoEncontrado = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				try {
					DlgBuscarProducto dialog = new DlgBuscarProducto();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgBuscarProducto() {
		setModal(true);
		setResizable(false);
		setTitle("Buscar Producto");
		setBounds(100, 100, 455, 444);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 443, 407);
		getContentPane().add(panel);
		
		JLabel lblBuscarProducto = new JLabel("BUSCAR PRODUCTO");
		lblBuscarProducto.setOpaque(true);
		lblBuscarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProducto.setForeground(Color.WHITE);
		lblBuscarProducto.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBuscarProducto.setBackground(new Color(141, 190, 248));
		lblBuscarProducto.setBounds(10, 11, 416, 39);
		panel.add(lblBuscarProducto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 416, 286);
		panel.add(scrollPane);
		
		tblProductos = new JTable();
		model = new DefaultTableModel();
		tblProductos.setModel(model);
		model.addColumn("Código");
		model.addColumn("Producto");
		model.addColumn("Stock");
		model.addColumn("Precio Unit.");
		scrollPane.setViewportView(tblProductos);
		
		btnSeleccionar = new JButton("SELECCIONAR");		
		btnSeleccionar.setBounds(174, 357, 103, 23);
		panel.add(btnSeleccionar);
		
		listado();

		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		
	}
	
	private void listado() {
		ArrayList<Producto> lista = new GestionProductos().listado();
		
		if (lista == null){
			JOptionPane.showMessageDialog(this, "Listado vacio");
		} else{
			model.setRowCount(0);
			for (Producto p : lista){
				insertarNuevaFila(p);				
			}
		}
	}
	
	public Producto showDialog() {
		setVisible(true);
		
		return obtenerProducto();
	}
	
	private Producto obtenerProducto() {
		
		int fila = tblProductos.getSelectedRow();
		
		if (fila == -1) {
			return null;
		}
		
		String codigo = tblProductos.getValueAt(fila, 0).toString();
		
		return new GestionProductos().buscar(codigo);
	}
	
	private void insertarNuevaFila(Producto p) {
		Object datos[] = {p.getCodigo(), p.getDescripcion(), p.getStock(), p.getPrecioUnitario()};
		model.addRow(datos);
	}
	
}
