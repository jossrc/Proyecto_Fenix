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
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public RepBoleta() {
		setLayout(null);
		
		JPanel pBoleta = new JPanel();
		pBoleta.setBounds(0, 0, 827, 570);
		add(pBoleta);
		pBoleta.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 189, 616, 310);
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
		btnBuscar.setBounds(687, 189, 117, 43);
		pBoleta.add(btnBuscar);
		
		JButton btnVisualizar = new JButton("VISUALIZAR");
		btnVisualizar.setForeground(Color.WHITE);
		btnVisualizar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVisualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVisualizar.setContentAreaFilled(false);
		btnVisualizar.setOpaque(true);
		btnVisualizar.setBorder(null);
		btnVisualizar.setBackground(Color.GRAY);
		btnVisualizar.setBounds(687, 262, 117, 43);
		pBoleta.add(btnVisualizar);
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setContentAreaFilled(false);
		btnImprimir.setOpaque(true);
		btnImprimir.setBorder(null);
		btnImprimir.setBackground(Color.GRAY);
		btnImprimir.setBounds(687, 334, 117, 43);
		pBoleta.add(btnImprimir);
		
		JPanel pTipoBusqueda = new JPanel();
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda por Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pTipoBusqueda.setBorder(titled);
		pTipoBusqueda.setBounds(45, 11, 620, 149);
		pBoleta.add(pTipoBusqueda);
		pTipoBusqueda.setLayout(null);
		
		JLabel label = new JLabel("Buscar por N\u00B0 Boleta");
		label.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label.setBounds(62, 18, 132, 19);
		pTipoBusqueda.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(316, 18, 265, 20);
		pTipoBusqueda.add(textField);
		
		JLabel label_1 = new JLabel("Buscar por N\u00B0 Documento (DNI/RUC)");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_1.setBounds(62, 56, 233, 19);
		pTipoBusqueda.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(316, 56, 265, 20);
		pTipoBusqueda.add(textField_1);
		
		JLabel label_2 = new JLabel("Buscar por Rango de Fechas");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_2.setBounds(62, 102, 186, 19);
		pTipoBusqueda.add(label_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(294, 102, 107, 20);
		pTipoBusqueda.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(474, 102, 107, 20);
		pTipoBusqueda.add(dateChooser_1);
		
		JLabel label_3 = new JLabel("hasta");
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_3.setBounds(422, 103, 35, 19);
		pTipoBusqueda.add(label_3);
		
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
