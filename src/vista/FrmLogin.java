package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionLogin;
import model.Login;
import model.Vendedor;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JLabel lblTitulo;
	private JLabel lblIconUser;
	private JLabel lblIconClave;
	private JButton btnIniciarSesion;
	
	private Color principalColor = new Color(247,71,38);
	private JLabel lblNewLabel;
	
	// GLOBAL
	public static Vendedor vendedorLogueado = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/img/fenix_icon.png")));
		setTitle("Iniciar Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 440);
		panel.setBackground(principalColor);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator sep01 = new JSeparator();
		sep01.setBounds(40, 251, 316, 7);
		panel.add(sep01);
		
		txtUserName = new JTextField();		
		txtUserName.setForeground(Color.WHITE);
		txtUserName.setBorder(null);
		txtUserName.setBackground(principalColor);
		txtUserName.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		txtUserName.setBounds(97, 214, 259, 38);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		JSeparator sep02 = new JSeparator();
		sep02.setBounds(40, 341, 316, 7);
		panel.add(sep02);
		
		txtPassword = new JPasswordField();		
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setBorder(null);
		txtPassword.setBackground(principalColor);
		txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtPassword.setBounds(97, 304, 259, 38);
		panel.add(txtPassword);
		
		lblTitulo = new JLabel("F\u00E9nix Juguetes de Colecci\u00F3n");
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTitulo.setBounds(97, 11, 205, 19);
		panel.add(lblTitulo);
		
		lblIconUser = new JLabel("");
		lblIconUser.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/userLoginIconWhite.png")));
		lblIconUser.setBounds(40, 214, 46, 38);
		panel.add(lblIconUser);
		
		lblIconClave = new JLabel("");
		lblIconClave.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/keyLoginIconWhite.png")));
		lblIconClave.setBounds(40, 299, 46, 38);
		panel.add(lblIconClave);
		
		btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");		
		btnIniciarSesion.setEnabled(false);
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.setOpaque(true);
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.setBackground(new Color(211,211,211));
		btnIniciarSesion.setBounds(40, 387, 316, 42);
		panel.add(btnIniciarSesion);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/fenixLoginIcon.png")));
		lblNewLabel.setBounds(125, 41, 150, 150);
		panel.add(lblNewLabel);
		
		txtUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				int lngUsername = txtUserName.getText().trim().length();
				int lngPassword = String.valueOf(txtPassword.getPassword()).trim().length();
				
				boolean verificar = lngUsername >= 4 && lngPassword >= 6;
				btnIniciarSesion.setEnabled(verificar);
				
				if (verificar) {					
					btnIniciarSesion.setBackground(Color.GRAY);
				} else {
					btnIniciarSesion.setBackground(new Color(211,211,211));
				}

			}
		});
	
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				int lngUsername = txtUserName.getText().trim().length();
				int lngPassword = String.valueOf(txtPassword.getPassword()).trim().length();
				
				boolean verificar = lngUsername >= 4 && lngPassword >= 6;
				btnIniciarSesion.setEnabled(verificar);
				
				if (verificar) {					
					btnIniciarSesion.setBackground(Color.GRAY);
				} else {
					btnIniciarSesion.setBackground(new Color(211,211,211));
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				char espacio = e.getKeyChar();
				if (espacio == 32) {
					e.consume();
				}
			}
		});
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarSesion();
			}
		});
	}
	
	private void iniciarSesion() {
		if (vendedorLogueado == null) {
			cargarVendedor();
			
			FrmPrincipal principal = new FrmPrincipal();
			principal.setLocationRelativeTo(null);
			principal.setVisible(true);
			
			dispose();
		}
	}
	
	private void cargarVendedor() {
		Login login = cargarLogin();
		
		if (login != null ) {
			vendedorLogueado = new GestionLogin().obtenerVendedorYLogueo(login.getIdVendedor());
		}
	}
	
	
	private Login cargarLogin() {
		String username = leerUserName();
		String clave;
		
		if (username != null) {
			clave = leerPassword();
			
			if (clave != null) {
				return new GestionLogin().iniciarSesion(username, clave);
			}			
		}
		
		return null;		
	}
	
	private String leerUserName() {
		String userName = txtUserName.getText().toLowerCase().trim();
		
		if (userName.isEmpty()) {
			aviso("El userName está vacío");
			return null;
		}
		
		if (!userName.matches("[a-z0-9]{4,15}")) {
			aviso("Ingrese un userName válido");
			return null;
		}
		
		return userName;
	}
	
	private String leerPassword() {
		String clave;
		
		if (txtPassword.getPassword().length == 0) {
			aviso("La clave está vacía");
			return null;
		}
		
		clave = String.valueOf(txtPassword.getPassword()).trim();
		
		if (clave.isEmpty()) {
			aviso("La clave está vacía");
			return null;
		}
		
		if (clave.length() < 6) {
			aviso("Ingrese una clave válida");
			return null;
		}
		
		return clave;
	}
	
	private void aviso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Aviso", 2);
	}
	
}
