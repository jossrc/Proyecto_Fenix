package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgBuscarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tblCliente;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		setBounds(100, 100, 442, 420);
		getContentPane().setLayout(null);
		
		JPanel pContenido = new JPanel();
		pContenido.setBounds(0, 0, 436, 391);
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
		scrollPane.setViewportView(tblCliente);
		
		JButton btnSeleccionar = new JButton("SELECCIONAR");		
		btnSeleccionar.setBounds(174, 357, 103, 23);
		pContenido.add(btnSeleccionar);
		
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	}
}
