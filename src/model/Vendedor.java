package model;

public class Vendedor {
	private int id_vend;
	private String dni_vend;
	private String nom_vend;
	private String ape_vend;
	private String dire_vend;
	private String telef_vend;
	private int  estado_vend;
	
	
	
	public Vendedor(int id_vend, String dni_vend, String nom_vend, String ape_vend, String dire_vend, String telef_vend,
			int estado_vend) {
		super();
		this.id_vend = id_vend;
		this.dni_vend = dni_vend;
		this.nom_vend = nom_vend;
		this.ape_vend = ape_vend;
		this.dire_vend = dire_vend;
		this.telef_vend = telef_vend;
		this.estado_vend = estado_vend;
	}
	
	public Vendedor() {
		
	}
	
	public int getId_vend() {
		return id_vend;
	}
	public void setId_vend(int id_vend) {
		this.id_vend = id_vend;
	}
	public String getDni_vend() {
		return dni_vend;
	}
	public void setDni_vend(String dni_vend) {
		this.dni_vend = dni_vend;
	}
	public String getNom_vend() {
		return nom_vend;
	}
	public void setNom_vend(String nom_vend) {
		this.nom_vend = nom_vend;
	}
	public String getApe_vend() {
		return ape_vend;
	}
	public void setApe_vend(String ape_vend) {
		this.ape_vend = ape_vend;
	}
	public String getDire_vend() {
		return dire_vend;
	}
	public void setDire_vend(String dire_vend) {
		this.dire_vend = dire_vend;
	}
	public String getTelef_vend() {
		return telef_vend;
	}
	public void setTelef_vend(String telef_vend) {
		this.telef_vend = telef_vend;
	}
	public int getEstado_vend() {
		return estado_vend;
	}
	public void setEstado_vend(int estado_vend) {
		this.estado_vend = estado_vend;
	}

}
