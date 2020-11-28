package interfaces;

import model.Login;
import model.Vendedor;

public interface LoginInterface {

	public Login iniciarSesion();
	
	public Vendedor obtenerVendedorYLogueo(int id);
	
}
