package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VendedorInterface;
import model.Vendedor;
import util.MySQLConexion8;

public class GestionVendedores implements VendedorInterface {

	@Override
	public int registrar(Vendedor vendedor) {
		int rs = 0;

		
		return rs;
	}

	@Override
	public int actualizar(Vendedor vendedor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vendedor buscar(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminar(String dni) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Vendedor> listado() {
		// TODO Auto-generated method stub
		return null;
	}

}
