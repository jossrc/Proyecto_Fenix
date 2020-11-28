package interfaces;

import model.Login;
import model.Vendedor;

public interface LoginInterface {

	public Login iniciarSesion(String username, String clave);
	
	public Vendedor obtenerVendedorYLogueo(int id);
	
}
