package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

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
		btnBoleta.setContentAreaFilled(false);
		btnBoleta.setBorder(null);
		btnBoleta.setBackground(Color.LIGHT_GRAY);
		btnBoleta.setBounds(122, 11, 117, 29);
		pSubmenu.add(btnBoleta);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.setOpaque(true);
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnProductos.setContentAreaFilled(false);
		btnProductos.setBorder(null);
		btnProductos.setBackground(Color.LIGHT_GRAY);
		btnProductos.setBounds(322, 11, 117, 29);
		pSubmenu.add(btnProductos);
		
		JButton btnVentasConcretadas = new JButton("Ventas Concretadas");
		btnVentasConcretadas.setOpaque(true);
		btnVentasConcretadas.setForeground(Color.WHITE);
		btnVentasConcretadas.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVentasConcretadas.setContentAreaFilled(false);
		btnVentasConcretadas.setBorder(null);
		btnVentasConcretadas.setBackground(Color.LIGHT_GRAY);
		btnVentasConcretadas.setBounds(516, 11, 141, 29);
		pSubmenu.add(btnVentasConcretadas);

	}

}
