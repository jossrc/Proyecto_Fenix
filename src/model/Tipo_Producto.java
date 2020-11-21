package model;

public class Tipo_Producto {
		private int id_tipo_pro;
		private String desc_tipo;
		
		
		
		public Tipo_Producto(int id_tipo_pro, String desc_tipo) {
			super();
			this.id_tipo_pro = id_tipo_pro;
			this.desc_tipo = desc_tipo;
		}
		
		
		
		public Tipo_Producto() {
			super();
		}

		

		public int getId_tipo_pro() {
			return id_tipo_pro;
		}
		public void setId_tipo_pro(int id_tipo_pro) {
			this.id_tipo_pro = id_tipo_pro;
		}
		public String getDesc_tipo() {
			return desc_tipo;
		}
		public void setDesc_tipo(String desc_tipo) {
			this.desc_tipo = desc_tipo;
		}
	
	
}
