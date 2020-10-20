package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class POpciones extends JPanel {

	private static final long serialVersionUID = 1L;

	public POpciones() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 828, 51);
		add(panel);
		
		JButton btnTasaCambios = new JButton("Tasa de Cambios");
		btnTasaCambios.setOpaque(true);
		btnTasaCambios.setForeground(Color.WHITE);
		btnTasaCambios.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTasaCambios.setContentAreaFilled(false);
		btnTasaCambios.setBorder(null);
		btnTasaCambios.setBackground(Color.LIGHT_GRAY);
		btnTasaCambios.setBounds(122, 11, 141, 29);
		panel.add(btnTasaCambios);
		
		JButton btnDescuentos = new JButton("Descuentos");
		btnDescuentos.setOpaque(true);
		btnDescuentos.setForeground(Color.WHITE);
		btnDescuentos.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDescuentos.setContentAreaFilled(false);
		btnDescuentos.setBorder(null);
		btnDescuentos.setBackground(Color.LIGHT_GRAY);
		btnDescuentos.setBounds(516, 11, 117, 29);
		panel.add(btnDescuentos);

	}

}
