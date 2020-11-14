package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;

public class FrmLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtPassword;

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
		setTitle("Iniciar Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 421);
		panel.setBackground(new Color(241, 71, 38));
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setForeground(Color.WHITE);
		txtUserName.setBorder(null);
		txtUserName.setBackground(new Color(241, 71, 38));
		txtUserName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		txtUserName.setBounds(90, 167, 266, 38);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		JSeparator sep01 = new JSeparator();
		sep01.setBounds(40, 209, 316, 7);
		panel.add(sep01);
		
		txtPassword = new JTextField();
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setBorder(null);
		txtPassword.setBackground(new Color(241, 71, 38));
		txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(90, 257, 266, 38);
		panel.add(txtPassword);
		
		JSeparator sep02 = new JSeparator();
		sep02.setBounds(40, 299, 316, 7);
		panel.add(sep02);
	}
}
