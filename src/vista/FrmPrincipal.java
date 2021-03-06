package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Animacion.Animacion;
import model.Vendedor;
import rsbutton.RSButtonMetro;
import util.CambiaPanel;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.CardLayout;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pContenido;
	
	private JLabel lblNombreDelVendedor;
	private JLabel lblApellidoDelVendedor;
	private JLabel lblTipovendedorAsistente;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/fenix_icon.png")));
		setResizable(false);
		setTitle("F\u00e9nix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pPrincipal = new JPanel();
		pPrincipal.setBackground(new Color(240, 240, 240));
		pPrincipal.setBounds(0, 0, 1018, 693);
		contentPane.add(pPrincipal);
		pPrincipal.setLayout(null);

		JPanel pEncabezado = new JPanel();
		pEncabezado.setBackground(new Color(241, 71, 38));
		pEncabezado.setBounds(0, 0, 1018, 69);
		pPrincipal.add(pEncabezado);
		pEncabezado.setLayout(null);

		JButton btnMenu = new JButton("");
		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenu.setContentAreaFilled(false);
		btnMenu.setOpaque(true);
		btnMenu.setBorder(null);
		btnMenu.setBackground(new Color(241, 71, 38));
		btnMenu.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/menu.png")));
		btnMenu.setBounds(10, 11, 57, 47);
		pEncabezado.add(btnMenu);

		JLabel lblTitulo = new JLabel("F\u00e9nix Juguetes de Colecci\u00f3n");
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitulo.setBounds(382, 22, 254, 24);
		pEncabezado.add(lblTitulo);
		ImageIcon perfil = new ImageIcon("src/img/perfil.png");

		JPanel pLateral = new JPanel();
		pLateral.setBounds(0, 69, 192, 624);
		pPrincipal.add(pLateral);
		pLateral.setLayout(null);
		pLateral.setBackground(Color.LIGHT_GRAY);

		JPanel pMenu = new JPanel();
		pMenu.setBounds(0, 0, 192, 624);
		pLateral.add(pMenu);
		pMenu.setBackground(new Color(143, 143, 143));
		pMenu.setLayout(null);

		JPanel pImagenVendedor = new JPanel();
		pImagenVendedor.setBackground(new Color(143, 143, 143));
		pImagenVendedor.setBounds(0, 0, 192, 115);
		pMenu.add(pImagenVendedor);
		pImagenVendedor.setLayout(null);

		JLabel lblImagenVendedor = new JLabel("");
		lblImagenVendedor.setBounds(50, 11, 90, 90);
		Icon icono = new ImageIcon(perfil.getImage().getScaledInstance(lblImagenVendedor.getWidth(),
				lblImagenVendedor.getHeight(), Image.SCALE_SMOOTH));
		lblImagenVendedor.setIcon(icono);
		pImagenVendedor.add(lblImagenVendedor);

		RSButtonMetro btnMantenimiento = new RSButtonMetro();
		btnMantenimiento.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnMantenimiento.setColorNormal(new Color(143, 143, 143));
		btnMantenimiento.setColorHover(new Color(153, 153, 153));
		btnMantenimiento.setText("Mantenimiento");
		btnMantenimiento.setBounds(0, 143, 190, 30);
		pMenu.add(btnMantenimiento);

		RSButtonMetro btnReporte = new RSButtonMetro();
		btnReporte.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnReporte.setColorNormal(new Color(143, 143, 143));
		btnReporte.setColorHover(new Color(153, 153, 153));
		btnReporte.setText("Reporte");
		btnReporte.setBounds(0, 226, 190, 30);
		pMenu.add(btnReporte);

		RSButtonMetro btnOpciones = new RSButtonMetro();
		btnOpciones.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnOpciones.setColorNormal(new Color(143, 143, 143));
		btnOpciones.setColorHover(new Color(153, 153, 153));
		btnOpciones.setText("Opciones");
		btnOpciones.setBounds(0, 272, 190, 30);
		pMenu.add(btnOpciones);

		RSButtonMetro btnAyuda = new RSButtonMetro();
		btnAyuda.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAyuda.setColorNormal(new Color(143, 143, 143));
		btnAyuda.setColorHover(new Color(153, 153, 153));
		btnAyuda.setText("Ayuda");
		btnAyuda.setBounds(0, 317, 190, 30);
		pMenu.add(btnAyuda);

		RSButtonMetro btnCerrarSesion = new RSButtonMetro();
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrarSesion.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCerrarSesion.setColorNormal(new Color(143, 143, 143));
		btnCerrarSesion.setColorHover(new Color(153, 153, 153));
		btnCerrarSesion.setText("Cerrar Sesi\u00f3n");
		btnCerrarSesion.setBounds(0, 532, 190, 30);
		pMenu.add(btnCerrarSesion);

		RSButtonMetro btnTransacciones = new RSButtonMetro();
		btnTransacciones.setText("Transacciones");
		btnTransacciones.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTransacciones.setColorNormal(new Color(143, 143, 143));
		btnTransacciones.setColorHover(new Color(153, 153, 153));
		btnTransacciones.setBounds(2, 185, 188, 30);
		pMenu.add(btnTransacciones);

		JPanel pLogueo = new JPanel();
		pLogueo.setBounds(0, 0, 192, 624);
		pLateral.add(pLogueo);
		pLogueo.setLayout(null);
		pLogueo.setBackground(Color.LIGHT_GRAY);

		JPanel pImagenLogueo = new JPanel();
		pImagenLogueo.setLayout(null);
		pImagenLogueo.setBackground(Color.LIGHT_GRAY);
		pImagenLogueo.setBounds(0, 0, 192, 115);
		pLogueo.add(pImagenLogueo);

		pContenido = new JPanel();
		pContenido.setBackground(new Color(240, 240, 240));
		pContenido.setBounds(191, 69, 827, 624);
		pPrincipal.add(pContenido);
		pContenido.setLayout(new CardLayout(0, 0));

		JLabel lblIconLogueo = new JLabel("");
		lblIconLogueo.setBounds(50, 11, 90, 90);
		ImageIcon imgVendedor = new ImageIcon("src/img/vendedor.png");
		Icon iconoVendedor = new ImageIcon(imgVendedor.getImage().getScaledInstance(lblIconLogueo.getWidth(),
				lblIconLogueo.getHeight(), Image.SCALE_SMOOTH));
		lblIconLogueo.setIcon(iconoVendedor);
		pImagenLogueo.add(lblIconLogueo);
		
		JLabel lblVendedorNombre = new JLabel("Nombre :");
		lblVendedorNombre.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblVendedorNombre.setBounds(10, 129, 85, 21);
		pLogueo.add(lblVendedorNombre);

		lblNombreDelVendedor = new JLabel("Nombre del vendedor");
		lblNombreDelVendedor.setFont(new Font("Verdana", Font.ITALIC, 15));
		lblNombreDelVendedor.setBounds(10, 161, 172, 21);
		pLogueo.add(lblNombreDelVendedor);

		JLabel lblVendedorApellido = new JLabel("Apellido :");
		lblVendedorApellido.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblVendedorApellido.setBounds(10, 207, 85, 21);
		pLogueo.add(lblVendedorApellido);

		lblApellidoDelVendedor = new JLabel("Apellido del vendedor");
		lblApellidoDelVendedor.setFont(new Font("Verdana", Font.ITALIC, 15));
		lblApellidoDelVendedor.setBounds(10, 239, 176, 20);
		pLogueo.add(lblApellidoDelVendedor);

		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblTipo.setBounds(10, 285, 44, 21);
		pLogueo.add(lblTipo);

		lblTipovendedorAsistente = new JLabel("Tipo Vendedor");
		lblTipovendedorAsistente.setFont(new Font("Verdana", Font.ITALIC, 15));
		lblTipovendedorAsistente.setBounds(10, 317, 172, 21);
		pLogueo.add(lblTipovendedorAsistente);

		JLabel lblFnix = new JLabel("F\u00E9nix");
		lblFnix.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblFnix.setBounds(77, 454, 38, 21);
		pLogueo.add(lblFnix);

		JLabel lblLaMejorJuguetera = new JLabel("La Mejor Jugueter\u00EDa");
		lblLaMejorJuguetera.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblLaMejorJuguetera.setBounds(27, 479, 137, 21);
		pLogueo.add(lblLaMejorJuguetera);

		JLabel lblNewLabel = new JLabel("de todos los tiempos");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 496, 145, 21);
		pLogueo.add(lblNewLabel);
		
		btnMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CambiaPanel(pContenido, new PMantenimiento());
			}
		});

		btnTransacciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CambiaPanel(pContenido, new PTransacciones());
			}
		});

		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CambiaPanel(pContenido, new PReporte());
			}
		});

		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CambiaPanel(pContenido, new POpciones());
			}
		});

		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CambiaPanel(pContenido, new PAyuda());
			}
		});

		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int posicion = pMenu.getX();
				if (posicion > -1) {
					Animacion.mover_izquierda(0, -192, 2, 2, pMenu);
				} else {
					Animacion.mover_derecha(-192, 0, 2, 2, pMenu);
				}
			}
		});
		
		cargarDatosVendedor();
		
	}
	
	
	private void cargarDatosVendedor() {
		
		Vendedor v = FrmLogin.vendedorLogueado;
		
		if (v != null) {
			
			lblNombreDelVendedor.setText(v.getNombre());
			lblApellidoDelVendedor.setText(v.getApellido());
			
			if (v.getTipo() == 0) {
				lblTipovendedorAsistente.setText("Administrador");
			} else {
				lblTipovendedorAsistente.setText("Vendedor Asistente");
			}

		}
	}
	
}
