package interfaces;

import java.util.ArrayList;

import model.TipoProducto;

public interface TipoProductoInterface {
	
	public TipoProducto buscarTipo(int num);

	public ArrayList<TipoProducto> listado();
	
}
