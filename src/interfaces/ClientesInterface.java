package interfaces;

import java.util.ArrayList;

import model.Cliente;



public interface ClientesInterface {
	
	public String generarCodigo();

	public int registrar(Cliente cliente);
	
	public int eliminar(String codigo);
	
	public int actualizar(Cliente cliente);
	
	public Cliente buscar(String codigo);
	
	public ArrayList<Cliente> listado();

}
