package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Animacion.Animacion;
import rsbutton.RSButtonMetro;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
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
		
		JButton btnMenu = new JButton("");		
		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenu.setContentAreaFilled(false);
		btnMenu.setOpaque(true);
		btnMenu.setBorder(null);
		btnMenu.setBackground(new Color(241,71,38));
		btnMenu.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/menu.png")));
		btnMenu.setBounds(10, 11, 57, 47);
		pEncabezado.add(btnMenu);
		
		JPanel pLateral = new JPanel();
		pLateral.setBackground(new Color(143,143,143));
		pLateral.setBounds(0, 69, 192, 479);
		pPrincipal.add(pLateral);
		pLateral.setLayout(null);
		
		JPanel pImagenVendedor = new JPanel();
		pImagenVendedor.setBackground(new Color(143,143,143));
		pImagenVendedor.setBounds(0, 0, 192, 115);
		pLateral.add(pImagenVendedor);
		pImagenVendedor.setLayout(null);
		
		JLabel lblImagenVendedor = new JLabel("");		
		lblImagenVendedor.setBounds(50, 11, 90, 90);
		ImageIcon perfil = new ImageIcon("src/img/perfil.png");
		Icon icono = new ImageIcon(perfil.getImage().getScaledInstance(lblImagenVendedor.getWidth(), lblImagenVendedor.getHeight(), Image.SCALE_SMOOTH));
		lblImagenVendedor.setIcon(icono);
		pImagenVendedor.add(lblImagenVendedor);
		
		RSButtonMetro btnMantenimiento = new RSButtonMetro();
		btnMantenimiento.setText("Mantenimiento");
		btnMantenimiento.setBounds(0, 143, 192, 23);
		pLateral.add(btnMantenimiento);
		
		RSButtonMetro btnReporte = new RSButtonMetro();
		btnReporte.setText("Reporte");
		btnReporte.setBounds(0, 192, 192, 23);
		pLateral.add(btnReporte);
		
		RSButtonMetro btnOpciones = new RSButtonMetro();
		btnOpciones.setText("Opciones");
		btnOpciones.setBounds(0, 238, 192, 23);
		pLateral.add(btnOpciones);
		
		RSButtonMetro btnAyuda = new RSButtonMetro();
		btnAyuda.setText("Ayuda");
		btnAyuda.setBounds(0, 283, 192, 23);
		pLateral.add(btnAyuda);
		
		RSButtonMetro btnCerrarSesion = new RSButtonMetro();
		btnCerrarSesion.setText("Cerrar Sesi\u00f3n");
		btnCerrarSesion.setBounds(0, 445, 192, 23);
		pLateral.add(btnCerrarSesion);
		
		JPanel pContenido = new JPanel();
		pContenido.setBackground(new Color(240,240,240));
		pContenido.setBounds(190, 69, 724, 479);
		pPrincipal.add(pContenido);
		pContenido.setLayout(null);
		
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int posicion = pLateral.getX();
				if (posicion > -1) {
					Animacion.mover_izquierda(0, -192, 2, 2, pLateral);
				} else {
					Animacion.mover_derecha(-192, 0, 2, 2, pLateral);
				}
			}
		});
	}
}
