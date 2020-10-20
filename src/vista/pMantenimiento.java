package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.CardLayout;

public class pMantenimiento extends JPanel {

	private static final long serialVersionUID = 1L;

	public pMantenimiento() {
		setLayout(null);
		
		JPanel pSubmenu = new JPanel();
		pSubmenu.setBackground(Color.LIGHT_GRAY);
		pSubmenu.setBounds(0, 0, 828, 51);
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
		
		JButton btnVentas = new JButton("Ventas");
		btnVentas.setForeground(Color.WHITE);
		btnVentas.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVentas.setContentAreaFilled(false);
		btnVentas.setOpaque(true);
		btnVentas.setBorder(null);
		btnVentas.setBackground(Color.LIGHT_GRAY);		
		btnVentas.setBounds(322, 11, 117, 29);
		pSubmenu.add(btnVentas);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProductos.setContentAreaFilled(false);
		btnProductos.setOpaque(true);
		btnProductos.setBorder(null);
		btnProductos.setBackground(Color.LIGHT_GRAY);
		btnProductos.setBounds(516, 11, 117, 29);
		pSubmenu.add(btnProductos);
		
		JPanel pContenidoMantenimiento = new JPanel();
		pContenidoMantenimiento.setBounds(0, 50, 828, 612);
		add(pContenidoMantenimiento);
		pContenidoMantenimiento.setLayout(new CardLayout(0, 0));

	}

}
