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
	private JTextField txtCantidadAVisualizar;

	public RepVentConcretadas() {
		setLayout(null);
		
		JPanel panelVentasConcretadas = new JPanel();		
		panelVentasConcretadas.setBounds(0, 0, 817, 551);
		add(panelVentasConcretadas);
		panelVentasConcretadas.setLayout(null);
		
		JPanel pBusquedasFecha = new JPanel();
		pBusquedasFecha.setBorder(crearBordeTitulo("Opciones de B\u00fasqueda por Fecha"));
		pBusquedasFecha.setBounds(21, 28, 544, 141);
		panelVentasConcretadas.add(pBusquedasFecha);
		pBusquedasFecha.setLayout(null);
		
		JLabel lblDesde = new JLabel("DESDE");
		lblDesde.setBounds(10, 18, 32, 14);
		pBusquedasFecha.add(lblDesde);
		
		JDateChooser txtDesde = new JDateChooser();
		txtDesde.setBounds(10, 43, 139, 20);
		pBusquedasFecha.add(txtDesde);
		
		JLabel lblHasta = new JLabel("HASTA");
		lblHasta.setBounds(10, 74, 33, 14);
		pBusquedasFecha.add(lblHasta);
		
		JDateChooser txtHasta = new JDateChooser();
		txtHasta.setBounds(10, 99, 139, 20);
		pBusquedasFecha.add(txtHasta);
		
		JLabel lblCantidadEncontrada = new JLabel("CANTIDAD ENCONTRADA");
		lblCantidadEncontrada.setBounds(205, 18, 124, 14);
		pBusquedasFecha.add(lblCantidadEncontrada);
		
		txtCantidadEncontrada = new JTextField();
		txtCantidadEncontrada.setEditable(false);
		txtCantidadEncontrada.setBounds(205, 43, 162, 20);
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
		btnBuscarVentas.setBounds(205, 88, 162, 31);
		pBusquedasFecha.add(btnBuscarVentas);
		
		JPanel pFiltroCantidad = new JPanel();
		pFiltroCantidad.setLayout(null);
		pFiltroCantidad.setBorder(crearBordeTitulo("Opciones de B\u00fasqueda por Fecha"));
		pFiltroCantidad.setBounds(21, 191, 544, 82);
		panelVentasConcretadas.add(pFiltroCantidad);
		
		JLabel lblCantidadAVisualizar = new JLabel("VISUALIZAR");
		lblCantidadAVisualizar.setBounds(10, 18, 59, 14);
		pFiltroCantidad.add(lblCantidadAVisualizar);
		
		txtCantidadAVisualizar = new JTextField();
		txtCantidadAVisualizar.setColumns(10);
		txtCantidadAVisualizar.setBounds(10, 44, 162, 20);
		pFiltroCantidad.add(txtCantidadAVisualizar);
		
		JButton btnGenerarReporte = new JButton("GENERAR REPORTE");
		btnGenerarReporte.setForeground(Color.WHITE);
		btnGenerarReporte.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGenerarReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerarReporte.setContentAreaFilled(false);
		btnGenerarReporte.setOpaque(true);
		btnGenerarReporte.setBorder(null);
		btnGenerarReporte.setBackground(new Color(9, 168, 136));
		btnGenerarReporte.setBounds(198, 33, 162, 31);
		pFiltroCantidad.add(btnGenerarReporte);
		
		JButton btnCancelarReporte = new JButton("CANCELAR REPORTE");
		btnCancelarReporte.setForeground(Color.WHITE);
		btnCancelarReporte.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelarReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelarReporte.setContentAreaFilled(false);
		btnCancelarReporte.setOpaque(true);
		btnCancelarReporte.setBorder(null);
		btnCancelarReporte.setBackground(new Color(241, 71, 38));
		btnCancelarReporte.setBounds(372, 33, 162, 31);
		pFiltroCantidad.add(btnCancelarReporte);
	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
}
