package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmPrincipal() {
		setResizable(false);
		setTitle("Fenix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pPrincipal = new JPanel();
		pPrincipal.setBackground(new Color(240,240,240));
		pPrincipal.setBounds(0, 0, 914, 548);
		contentPane.add(pPrincipal);
		pPrincipal.setLayout(null);
		
		JPanel pEncabezado = new JPanel();
		pEncabezado.setBackground(new Color(241, 71, 38));
		pEncabezado.setBounds(0, 0, 914, 69);
		pPrincipal.add(pEncabezado);
		pEncabezado.setLayout(null);
		
		JPanel pLateral = new JPanel();
		pLateral.setBackground(new Color(143,143,143));
		pLateral.setBounds(0, 69, 192, 479);
		pPrincipal.add(pLateral);
		pLateral.setLayout(null);
		
		JPanel pContenido = new JPanel();
		pContenido.setBackground(new Color(240,240,240));
		pContenido.setBounds(190, 69, 724, 479);
		pPrincipal.add(pContenido);
		pContenido.setLayout(null);
	}
}
