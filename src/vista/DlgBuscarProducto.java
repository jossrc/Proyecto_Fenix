package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class DlgBuscarProducto extends JDialog {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgBuscarProducto dialog = new DlgBuscarProducto();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgBuscarProducto() {
		setBounds(100, 100, 616, 508);
		getContentPane().setLayout(null);

	}

}
