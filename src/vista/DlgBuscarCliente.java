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

import mantenimientos.GestionClientes;
import model.Cliente;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DlgBuscarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tblCliente;
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				try {
					DlgBuscarCliente dialog = new DlgBuscarCliente();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgBuscarCliente() {
		setResizable(false);
		setTitle("BuscarCliente");
		setBounds(100, 100, 452, 436);
		getContentPane().setLayout(null);
		
		JPanel pContenido = new JPanel();
		pContenido.setBounds(0, 0, 443, 407);
		getContentPane().add(pContenido);
		pContenido.setLayout(null);
		
		JLabel lblBuscarCliente = new JLabel("BUSCAR CLIENTE");
		lblBuscarCliente.setOpaque(true);
		lblBuscarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarCliente.setForeground(Color.WHITE);
		lblBuscarCliente.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBuscarCliente.setBackground(new Color(141, 190, 248));
		lblBuscarCliente.setBounds(10, 11, 416, 39);
		pContenido.add(lblBuscarCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 416, 286);
		pContenido.add(scrollPane);
		
		tblCliente = new JTable();		
		model = new DefaultTableModel();
		tblCliente.setModel(model);
		model.addColumn("N°");
		model.addColumn("DNI");
		model.addColumn("Cliente");
		scrollPane.setViewportView(tblCliente);
		
		JButton btnSeleccionar = new JButton("SELECCIONAR");		
		btnSeleccionar.setBounds(174, 357, 103, 23);
		pContenido.add(btnSeleccionar);
		
		listadoClientes();
		
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				obtenerCliente();
			}
		});
	}
	
	private void obtenerCliente() {
		int fila = tblCliente.getSelectedRow();
		
		String id = tblCliente.getValueAt(fila, 0).toString();
		String nombreCompleto = tblCliente.getValueAt(fila, 2).toString();
		
		TRVentas.txtIDCliente.setText(id);
		TRVentas.txtCliente.setText(nombreCompleto);
		
		dispose();
	}
	
	private void listadoClientes() {
		ArrayList<Cliente> lista = new GestionClientes().listadoDesc();
		
		if (lista == null){
			JOptionPane.showMessageDialog(this, "Listado vacio");
		} else{
			model.setRowCount(0);
			for (Cliente c : lista){
				insertarNuevaFila(c);				
			}
		}
	}
	
	private void insertarNuevaFila(Cliente c) {
		Object datos[] = {c.getId_cli(), c.getDni_cli(), c.getNom_cli() + " " + c.getApe_cli()};
		model.addRow(datos);
	}
	
}
