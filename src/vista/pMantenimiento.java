package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class pMantenimiento extends JPanel {

	private static final long serialVersionUID = 1L;

	public pMantenimiento() {
		setLayout(null);
		
		JPanel pSubmenu = new JPanel();
		pSubmenu.setBackground(Color.LIGHT_GRAY);
		pSubmenu.setBounds(0, 0, 724, 51);
		add(pSubmenu);
		pSubmenu.setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBounds(102, 11, 117, 29);
		pSubmenu.add(btnCliente);
		
		JButton btnVentas = new JButton("Ventas");
		btnVentas.setBounds(303, 11, 117, 29);
		pSubmenu.add(btnVentas);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.setBounds(504, 11, 117, 29);
		pSubmenu.add(btnProductos);

	}
}
