package vista;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;


public class PTransacciones extends JPanel {

	private static final long serialVersionUID = 1L;

	
	public PTransacciones() {
		setLayout(null);
		
		JPanel pContenido = new JPanel();
		pContenido.setBounds(0, 0, 827, 621);
		add(pContenido);
		pContenido.setLayout(null);
		
		JPanel pSubmenu = new JPanel();
		pSubmenu.setLayout(null);
		pSubmenu.setBackground(Color.LIGHT_GRAY);
		pSubmenu.setBounds(0, 0, 827, 51);
		pContenido.add(pSubmenu);
		
		JButton btnVentas = new JButton("Ventas");
		btnVentas.setOpaque(true);
		btnVentas.setForeground(Color.WHITE);
		btnVentas.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVentas.setContentAreaFilled(false);
		btnVentas.setBorder(null);
		btnVentas.setBackground(Color.LIGHT_GRAY);
		btnVentas.setBounds(340, 11, 117, 29);
		pSubmenu.add(btnVentas);
		
		JPanel pContenidoVentas = new JPanel();
		pContenidoVentas.setBounds(0, 51, 827, 570);
		pContenido.add(pContenidoVentas);
		pContenidoVentas.setLayout(new CardLayout(0, 0));

	}
	
}
