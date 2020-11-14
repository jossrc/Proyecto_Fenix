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


public class PTransacciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel pContenidoVentas;
	private JPanel pSubmenu;
	private JButton btnVentas;

	
	public PTransacciones() {
		setLayout(null);
		
		JPanel pContenido = new JPanel();
		pContenido.setBounds(0, 0, 827, 621);
		add(pContenido);
		pContenido.setLayout(null);
		
		pSubmenu = new JPanel();
		pSubmenu.setLayout(null);
		pSubmenu.setBackground(Color.LIGHT_GRAY);
		pSubmenu.setBounds(0, 0, 827, 51);
		pContenido.add(pSubmenu);
		
		btnVentas = new JButton("Ventas");		
		btnVentas.setForeground(Color.WHITE);
		btnVentas.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVentas.setContentAreaFilled(false);
		btnVentas.setOpaque(true);
		btnVentas.setBorder(null);
		btnVentas.setBackground(Color.LIGHT_GRAY);
		btnVentas.setBounds(340, 11, 117, 29);
		pSubmenu.add(btnVentas);
		
		pContenidoVentas = new JPanel();
		pContenidoVentas.setBounds(0, 51, 827, 570);
		pContenido.add(pContenidoVentas);
		pContenidoVentas.setLayout(new CardLayout(0, 0));
		
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CambiaPanel(pContenidoVentas, new TRVentas());
			}
		});
		
		activarVentasDefault();

	}
	
	private void activarVentasDefault() {
		new CambiaPanel(pContenidoVentas, new TRVentas());
	}
	
}
