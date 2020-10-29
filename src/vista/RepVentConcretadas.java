package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class RepVentConcretadas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtCantidadEncontrada;

	public RepVentConcretadas() {
		setLayout(null);
		
		JPanel panelVentasConcretadas = new JPanel();
		panelVentasConcretadas.setBorder(crearBordeTitulo("Opciones de B\u00fasqueda por Fecha"));
		panelVentasConcretadas.setBounds(0, 0, 817, 551);
		add(panelVentasConcretadas);
		panelVentasConcretadas.setLayout(null);
		
		JPanel pBusquedasFecha = new JPanel();
		pBusquedasFecha.setBounds(21, 28, 544, 125);
		panelVentasConcretadas.add(pBusquedasFecha);
		pBusquedasFecha.setLayout(null);
		
		JLabel lblDesde = new JLabel("DESDE");
		lblDesde.setBounds(10, 9, 32, 14);
		pBusquedasFecha.add(lblDesde);
		
		JDateChooser txtDesde = new JDateChooser();
		txtDesde.setBounds(10, 34, 139, 20);
		pBusquedasFecha.add(txtDesde);
		
		JLabel lblHasta = new JLabel("HASTA");
		lblHasta.setBounds(10, 65, 33, 14);
		pBusquedasFecha.add(lblHasta);
		
		JDateChooser txtHasta = new JDateChooser();
		txtHasta.setBounds(10, 90, 139, 20);
		pBusquedasFecha.add(txtHasta);
		
		JLabel lblCantidadEncontrada = new JLabel("CANTIDAD ENCONTRADA");
		lblCantidadEncontrada.setBounds(205, 9, 124, 14);
		pBusquedasFecha.add(lblCantidadEncontrada);
		
		txtCantidadEncontrada = new JTextField();
		txtCantidadEncontrada.setEditable(false);
		txtCantidadEncontrada.setBounds(205, 34, 162, 20);
		pBusquedasFecha.add(txtCantidadEncontrada);
		txtCantidadEncontrada.setColumns(10);
		
		JButton btnBuscarVentas = new JButton("BUSCAR");
		btnBuscarVentas.setForeground(Color.WHITE);
		btnBuscarVentas.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscarVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarVentas.setContentAreaFilled(false);
		btnBuscarVentas.setOpaque(true);
		btnBuscarVentas.setBorder(null);
		btnBuscarVentas.setBackground(new Color(9, 168, 136));
		btnBuscarVentas.setBounds(205, 79, 162, 31);
		pBusquedasFecha.add(btnBuscarVentas);
	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
}
