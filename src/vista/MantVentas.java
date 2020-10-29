package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MantVentas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtCliente;
	private JTextField txtBoleta;

	public MantVentas() {
		setLayout(null);
		
		JPanel panelVentas = new JPanel();
		panelVentas.setBounds(0, 0, 817, 470);
		add(panelVentas);
		panelVentas.setLayout(null);		
		
		JPanel pDatosVenta = new JPanel();
		pDatosVenta.setBorder(crearBordeTitulo("Datos de venta"));
		pDatosVenta.setBounds(10, 11, 627, 79);
		panelVentas.add(pDatosVenta);
		pDatosVenta.setLayout(null);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(21, 19, 46, 14);
		pDatosVenta.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(21, 44, 219, 20);
		pDatosVenta.add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblDocumento = new JLabel("DOCUMENTO");
		lblDocumento.setBounds(313, 19, 64, 14);
		pDatosVenta.add(lblDocumento);
		
		txtBoleta = new JTextField();
		txtBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoleta.setText("BOLETA");
		txtBoleta.setEditable(false);
		txtBoleta.setBounds(313, 44, 119, 20);
		pDatosVenta.add(txtBoleta);
		txtBoleta.setColumns(10);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(474, 19, 33, 14);
		pDatosVenta.add(lblFecha);
		
		JDateChooser txtFecha = new JDateChooser();
		txtFecha.setBounds(467, 44, 128, 20);
		pDatosVenta.add(txtFecha);
		
		JButton btnBuscarCliente = new JButton("");
		btnBuscarCliente.setBounds(250, 44, 32, 23);
		pDatosVenta.add(btnBuscarCliente);

	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
}
