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
	
	public int aplicarDescuentoXProducto(String codigo, int tipoDesc, double descuento );
	
	public int aplicarDescuentoXTipo(int tipoDesc, int tipoProd, double descuento);
	
	public int aplicarDescuentoXMarca(int tipoDesc, int tipoMarc, double descuento);
	
	public int aplicarDescuentoATodos(int tipoDesc, double descuento);
	
}
