package vista;

import javax.swing.JPanel;

import util.CambiaPanel;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PReporte extends JPanel {

	private static final long serialVersionUID = 1L;

	public PReporte() {
		setLayout(null);
		
		JPanel pSubmenu = new JPanel();
		pSubmenu.setLayout(null);
		pSubmenu.setBackground(Color.LIGHT_GRAY);
		pSubmenu.setBounds(0, 0, 828, 51);
		add(pSubmenu);
		
		JButton btnBoleta = new JButton("Boleta");		
		btnBoleta.setOpaque(true);
		btnBoleta.setForeground(Color.WHITE);
		btnBoleta.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBoleta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBoleta.setContentAreaFilled(false);
		btnBoleta.setBorder(null);
		btnBoleta.setBackground(Color.LIGHT_GRAY);
		btnBoleta.setBounds(122, 11, 117, 29);
		pSubmenu.add(btnBoleta);
		
		JButton btnProductos = new JButton("Productos");		
		btnProductos.setOpaque(true);
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProductos.setContentAreaFilled(false);
		btnProductos.setBorder(null);
		btnProductos.setBackground(Color.LIGHT_GRAY);
		btnProductos.setBounds(322, 11, 117, 29);
		pSubmenu.add(btnProductos);
		
		JButton btnVentasConcretadas = new JButton("Ventas Concretadas");		
		btnVentasConcretadas.setOpaque(true);
		btnVentasConcretadas.setForeground(Color.WHITE);
		btnVentasConcretadas.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVentasConcretadas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVentasConcretadas.setContentAreaFilled(false);
		btnVentasConcretadas.setBorder(null);
		btnVentasConcretadas.setBackground(Color.LIGHT_GRAY);
		btnVentasConcretadas.setBounds(516, 11, 141, 29);
		pSubmenu.add(btnVentasConcretadas);
		
		JPanel pContenidoReporte = new JPanel();
		pContenidoReporte.setBounds(0, 51, 827, 481);
		add(pContenidoReporte);
		pContenidoReporte.setLayout(new CardLayout(0, 0));
		
		btnBoleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new CambiaPanel(pContenidoReporte, content)
			}
		});
		
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new CambiaPanel(pContenidoReporte, content)
			}
		});
		
		btnVentasConcretadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new CambiaPanel(pContenidoReporte, content)
			}
		});

	}

}
