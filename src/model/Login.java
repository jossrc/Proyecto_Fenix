package model;

public class Login {

	private String username;
	private String clave;
	private int idVendedor;
	
	public Login(String username, String clave, int idVendedor) {
		this.username = username;
		this.clave = clave;
		this.idVendedor = idVendedor;
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

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

}
