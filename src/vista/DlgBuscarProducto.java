package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class DlgBuscarProducto extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tblProductos;
	private JButton btnSeleccionar;
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

	}
}
