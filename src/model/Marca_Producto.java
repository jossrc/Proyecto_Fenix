package model;

public class Marca_Producto {
	
	private int id_marc_pro;
	private String desc_marca;
	
	
	
	public Marca_Producto(int id_marc_pro, String desc_marca) {
		super();
		this.id_marc_pro = id_marc_pro;
		this.desc_marca = desc_marca;
	}
	
	
	
	public Marca_Producto() {
		
	}


	public int getId_marc_pro() {
		return id_marc_pro;
	}
	public void setId_marc_pro(int id_marc_pro) {
		this.id_marc_pro = id_marc_pro;
	}
	public String getDesc_marca() {
		return desc_marca;
	}
	public void setDesc_marca(String desc_marca) {
		this.desc_marca = desc_marca;
	}
	
	

}
