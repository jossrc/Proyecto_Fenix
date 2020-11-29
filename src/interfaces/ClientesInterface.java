package interfaces;

import java.util.ArrayList;

import model.Cliente;



public interface ClientesInterface {
	
	public int registrar(Cliente cliente);
	
	public int eliminar(String dni);
	
	public int actualizar(Cliente cliente);
	
	public Cliente buscar(String dni);
	
	public ArrayList<Cliente> listado();
	
	public ArrayList<Cliente> listadoDesc();

}
