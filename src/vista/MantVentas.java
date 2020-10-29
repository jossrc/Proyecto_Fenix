package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class MantVentas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtBoleta;

	public MantVentas() {
		setLayout(null);
		
		JPanel panelVentas = new JPanel();
		panelVentas.setBounds(0, 0, 817, 470);
		add(panelVentas);
		panelVentas.setLayout(null);
		
		JPanel pDatosVenta = new JPanel();
		pDatosVenta.setBounds(10, 11, 634, 75);
		panelVentas.add(pDatosVenta);
		pDatosVenta.setLayout(null);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(20, 11, 46, 14);
		pDatosVenta.add(lblCliente);
		
		textField = new JTextField();
		textField.setBounds(20, 36, 219, 20);
		pDatosVenta.add(textField);
		textField.setColumns(10);
		
		JLabel lblDocumento = new JLabel("DOCUMENTO");
		lblDocumento.setBounds(312, 11, 64, 14);
		pDatosVenta.add(lblDocumento);
		
		txtBoleta = new JTextField();
		txtBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoleta.setText("BOLETA");
		txtBoleta.setEditable(false);
		txtBoleta.setBounds(312, 36, 119, 20);
		pDatosVenta.add(txtBoleta);
		txtBoleta.setColumns(10);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(473, 11, 33, 14);
		pDatosVenta.add(lblFecha);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(466, 36, 128, 20);
		pDatosVenta.add(dateChooser);
		
		JButton btnBuscarCliente = new JButton("");
		btnBuscarCliente.setBounds(249, 35, 32, 23);
		pDatosVenta.add(btnBuscarCliente);

	}
}
