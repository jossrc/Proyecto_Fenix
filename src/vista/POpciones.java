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

public class POpciones extends JPanel {

	private static final long serialVersionUID = 1L;

	public POpciones() {
		setLayout(null);
		
		JPanel pSubmenu = new JPanel();
		pSubmenu.setLayout(null);
		pSubmenu.setBackground(Color.LIGHT_GRAY);
		pSubmenu.setBounds(0, 0, 828, 51);
		add(pSubmenu);
		
		JButton btnTasaCambios = new JButton("Tasa de Cambios");		
		btnTasaCambios.setOpaque(true);
		btnTasaCambios.setForeground(Color.WHITE);
		btnTasaCambios.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTasaCambios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTasaCambios.setContentAreaFilled(false);
		btnTasaCambios.setBorder(null);
		btnTasaCambios.setBackground(Color.LIGHT_GRAY);
		btnTasaCambios.setBounds(122, 11, 141, 29);
		pSubmenu.add(btnTasaCambios);
		
		JButton btnDescuentos = new JButton("Descuentos");		
		btnDescuentos.setOpaque(true);
		btnDescuentos.setForeground(Color.WHITE);
		btnDescuentos.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDescuentos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDescuentos.setContentAreaFilled(false);
		btnDescuentos.setBorder(null);
		btnDescuentos.setBackground(Color.LIGHT_GRAY);
		btnDescuentos.setBounds(516, 11, 117, 29);
		pSubmenu.add(btnDescuentos);
		
		JPanel pContenidoOpciones = new JPanel();
		pContenidoOpciones.setBounds(0, 51, 827, 570);
		add(pContenidoOpciones);
		pContenidoOpciones.setLayout(new CardLayout(0, 0));
		
		btnTasaCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new CambiaPanel(pContenidoOpciones, content);
			}
		});
		
		btnDescuentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CambiaPanel(pContenidoOpciones, new OpcDescuentos());
			}
		});

	}

}
