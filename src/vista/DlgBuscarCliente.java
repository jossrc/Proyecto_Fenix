package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class DlgBuscarCliente extends JDialog {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgBuscarCliente dialog = new DlgBuscarCliente();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgBuscarCliente() {
		setBounds(100, 100, 450, 300);

	}

}
