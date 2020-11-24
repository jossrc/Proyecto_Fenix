package interfaces;

import java.util.ArrayList;

import model.Vendedor;

public interface VendedorInterface {

	public int registrar(Vendedor vendedor);

	public int actualizar(Vendedor vendedor);

	public Vendedor buscar(String dni);

	public int eliminar(String dni);

	public ArrayList<Vendedor> listado();

}
