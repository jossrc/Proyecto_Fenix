package interfaces;

import java.util.ArrayList;

import model.Producto;

public interface ProductoInterface {
	
	public String generarCodigo();

	public int registrar(Producto producto);
	
	public int eliminar(String codigo);
	
	public int actualizar(Producto producto);
	
	public Producto buscar(String codigo);
	
	public ArrayList<Producto> listado();
	
}
