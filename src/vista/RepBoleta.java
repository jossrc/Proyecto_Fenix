package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RepBoleta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tblBoleta;
	private JTextField txtNumBoleta;
	private JTextField txtDNI_RUC;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public RepBoleta() {
		setLayout(null);
		
		JPanel pBoleta = new JPanel();
		pBoleta.setBounds(0, 0, 827, 570);
		add(pBoleta);
		pBoleta.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 215, 616, 310);
		pBoleta.add(scrollPane);
		
		tblBoleta = new JTable();
		scrollPane.setViewportView(tblBoleta);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.GRAY);
		btnBuscar.setBounds(665, 225, 117, 43);
		pBoleta.add(btnBuscar);
		
		JButton btnVisualizar = new JButton("VISUALIZAR");
		btnVisualizar.setForeground(Color.WHITE);
		btnVisualizar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVisualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVisualizar.setContentAreaFilled(false);
		btnVisualizar.setOpaque(true);
		btnVisualizar.setBorder(null);
		btnVisualizar.setBackground(Color.GRAY);
		btnVisualizar.setBounds(665, 294, 117, 43);
		pBoleta.add(btnVisualizar);
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setContentAreaFilled(false);
		btnImprimir.setOpaque(true);
		btnImprimir.setBorder(null);
		btnImprimir.setBackground(Color.GRAY);
		btnImprimir.setBounds(665, 370, 117, 43);
		pBoleta.add(btnImprimir);
		
		JPanel pTipoBusqueda = new JPanel();
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda por Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pTipoBusqueda.setBorder(titled);
		pTipoBusqueda.setBounds(14, 29, 620, 149);
		pBoleta.add(pTipoBusqueda);
		pTipoBusqueda.setLayout(null);
		
		JLabel lblBuscarBoleta = new JLabel("Buscar por N\u00B0 Boleta");
		lblBuscarBoleta.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblBuscarBoleta.setBounds(62, 18, 132, 19);
		pTipoBusqueda.add(lblBuscarBoleta);
		
		txtNumBoleta = new JTextField();
		txtNumBoleta.setColumns(10);
		txtNumBoleta.setBounds(316, 18, 265, 20);
		pTipoBusqueda.add(txtNumBoleta);
		
		JLabel lblBuscarDocumento = new JLabel("Buscar por N\u00B0 Documento (DNI/RUC)");
		lblBuscarDocumento.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblBuscarDocumento.setBounds(62, 56, 233, 19);
		pTipoBusqueda.add(lblBuscarDocumento);
		
		txtDNI_RUC = new JTextField();
		txtDNI_RUC.setColumns(10);
		txtDNI_RUC.setBounds(316, 56, 265, 20);
		pTipoBusqueda.add(txtDNI_RUC);
		
		JLabel lblBuscarRango = new JLabel("Buscar por Rango de Fechas");
		lblBuscarRango.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblBuscarRango.setBounds(62, 102, 186, 19);
		pTipoBusqueda.add(lblBuscarRango);
		
		JDateChooser txtFechInicial = new JDateChooser();
		txtFechInicial.setBounds(294, 102, 107, 20);
		pTipoBusqueda.add(txtFechInicial);
		
		JDateChooser txtFechFinal = new JDateChooser();
		txtFechFinal.setBounds(474, 102, 107, 20);
		pTipoBusqueda.add(txtFechFinal);
		
		JLabel lblHasta = new JLabel("hasta");
		lblHasta.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblHasta.setBounds(422, 103, 35, 19);
		pTipoBusqueda.add(lblHasta);
		
		JRadioButton rdbtnBoleta = new JRadioButton("");
		buttonGroup.add(rdbtnBoleta);
		rdbtnBoleta.setSelected(true);
		rdbtnBoleta.setBounds(28, 17, 28, 23);
		pTipoBusqueda.add(rdbtnBoleta);
		
		JRadioButton rdbtnDocumento = new JRadioButton("");
		buttonGroup.add(rdbtnDocumento);
		rdbtnDocumento.setBounds(28, 54, 28, 23);
		pTipoBusqueda.add(rdbtnDocumento);
		
		JRadioButton rdbtnRango = new JRadioButton("");
		buttonGroup.add(rdbtnRango);
		rdbtnRango.setBounds(28, 98, 28, 23);
		pTipoBusqueda.add(rdbtnRango);

	}
}
