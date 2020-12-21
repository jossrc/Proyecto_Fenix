package interfaces;

import java.util.ArrayList;

import model.ReporteProducto;

public interface ReporteProductoInterface {
	
	public ArrayList<ReporteProducto> listado();
	
	public ArrayList<ReporteProducto> listadoxmarca(int codMarca);
	
	public ArrayList<ReporteProducto> listadoxtipo (int codTipo);
	
	public ArrayList<ReporteProducto> listadoxtipoymarca(int codTipo, int codMarca);
	
	public ArrayList<ReporteProducto> listadoxstock (int stock);
	
	public ArrayList<ReporteProducto> listadoxprecio (double precio);
}
