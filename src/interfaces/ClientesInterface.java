package interfaces;

import java.util.ArrayList;

import model.Cliente;



public interface ClientesInterface {
	
	public int registrar(Cliente cliente);
	
	public int eliminar(int id);
	
	public int actualizar(Cliente cliente);
	
	public Cliente buscar(String dni);
	
	public ArrayList<Cliente> listado();

}
