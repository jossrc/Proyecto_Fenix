package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;

public class PAyuda extends JPanel {

	private static final long serialVersionUID = 1L;

	public PAyuda() {
		setLayout(null);
		
		JPanel pContenidoAyuda = new JPanel();
		pContenidoAyuda.setBounds(0, 0, 827, 614);
		add(pContenidoAyuda);
		pContenidoAyuda.setLayout(null);
		
		JLabel lblVersion = new JLabel("Versi\u00F3n 1.0.1");
		lblVersion.setBounds(335, 11, 158, 34);
		lblVersion.setFont(new Font("SansSerif", Font.BOLD, 26));
		pContenidoAyuda.add(lblVersion);
		
		JLabel lblDerechos = new JLabel("Todos los derechos reservados \u00A9 -");
		lblDerechos.setBounds(269, 572, 203, 18);
		lblDerechos.setFont(new Font("SansSerif", Font.ITALIC, 13));
		pContenidoAyuda.add(lblDerechos);
		
		Calendar cal = Calendar.getInstance();		
		JLabel lblYear = new JLabel();
		lblYear.setBounds(482, 572, 28, 18);
		lblYear.setFont(new Font("SansSerif", Font.ITALIC, 13));
		lblYear.setText(cal.get(Calendar.YEAR)+"");
		pContenidoAyuda.add(lblYear);

	}
}
