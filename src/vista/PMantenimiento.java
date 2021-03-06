package vista;

import javax.swing.JPanel;

import util.CambiaPanel;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PMantenimiento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnVendedores;

	public PMantenimiento() {
		setLayout(null);
		
		JPanel pSubmenu = new JPanel();
		pSubmenu.setBackground(Color.LIGHT_GRAY);
		pSubmenu.setBounds(0, 0, 827, 51);
		add(pSubmenu);
		pSubmenu.setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");		
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliente.setContentAreaFilled(false);
		btnCliente.setOpaque(true);
		btnCliente.setBorder(null);
		btnCliente.setBackground(Color.LIGHT_GRAY);
		btnCliente.setBounds(122, 11, 117, 29);
		pSubmenu.add(btnCliente);
		
		btnVendedores = new JButton("Vendedores");		
		btnVendedores.setForeground(Color.WHITE);
		btnVendedores.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVendedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVendedores.setContentAreaFilled(false);
		btnVendedores.setOpaque(true);
		btnVendedores.setBorder(null);
		btnVendedores.setBackground(Color.LIGHT_GRAY);		
		btnVendedores.setBounds(340, 11, 117, 29);
		btnVendedores.setVisible(false);
		pSubmenu.add(btnVendedores);
		
		JButton btnProductos = new JButton("Productos");		
		btnProductos.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProductos.setContentAreaFilled(false);
		btnProductos.setOpaque(true);
		btnProductos.setBorder(null);
		btnProductos.setBackground(Color.LIGHT_GRAY);
		btnProductos.setBounds(580, 11, 117, 29);
		pSubmenu.add(btnProductos);
		
		JPanel pContenidoMantenimiento = new JPanel();
		pContenidoMantenimiento.setBounds(0, 50, 827, 570);
		add(pContenidoMantenimiento);
		pContenidoMantenimiento.setLayout(new CardLayout(0, 0));
		
		habilitarBotonVendedor();
		
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CambiaPanel(pContenidoMantenimiento, new MantClientes());
			}
		});
		
		btnVendedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CambiaPanel(pContenidoMantenimiento, new MantVendedor());
			}
		});
		
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CambiaPanel(pContenidoMantenimiento, new MantProducto());
			}
		});
	}
	
	private void habilitarBotonVendedor() {
		if (FrmLogin.vendedorLogueado != null) {
			if (FrmLogin.vendedorLogueado.getTipo() == 0) {
				btnVendedores.setVisible(true);
			}
		}
	}

}
