package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.SwingConstants;

public class PAyuda extends JPanel {

	private static final long serialVersionUID = 1L;

	public PAyuda() {
		setLayout(null);
		
		JPanel pContenidoAyuda = new JPanel();
		pContenidoAyuda.setBounds(0, 0, 827, 614);
		add(pContenidoAyuda);
		pContenidoAyuda.setLayout(null);
		
		JLabel lblVersion = new JLabel("Versi\u00F3n 1.3.1");
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
		
		JLabel lblDesarrolladores = new JLabel("Desarrolladores:");
		lblDesarrolladores.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDesarrolladores.setBounds(358, 91, 135, 28);
		pContenidoAyuda.add(lblDesarrolladores);
		
		JLabel lblJosRobles = new JLabel("Jos\u00E9 Robles - jossrc10@gmail.com");
		lblJosRobles.setHorizontalAlignment(SwingConstants.CENTER);
		lblJosRobles.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblJosRobles.setBounds(284, 140, 278, 28);
		pContenidoAyuda.add(lblJosRobles);
		
		JLabel lblElenaEfimova = new JLabel("Elena Efimova - ayefimova@gmail.com");
		lblElenaEfimova.setHorizontalAlignment(SwingConstants.CENTER);
		lblElenaEfimova.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblElenaEfimova.setBounds(284, 167, 278, 34);
		pContenidoAyuda.add(lblElenaEfimova);

	}
}
