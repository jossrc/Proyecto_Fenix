package model;

public class Usuario {
	
	private String username;
	private String clave;
	private int id_vend;
	
	
	public Usuario(String username, String clave, int id_vend) {
		super();
		this.username = username;
		this.clave = clave;
		this.id_vend = id_vend;
	}
	
	
	public Usuario() {
		super();
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getId_vend() {
		return id_vend;
	}
	public void setId_vend(int id_vend) {
		this.id_vend = id_vend;
	}

}
