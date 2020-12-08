package model;

public class Cliente {
	private int id_cli;
	private String dni_cli;
	private String nom_cli;
	private String ape_cli;
	private String direc_cli;
	private String telef_cli;
	private int estado_cli;
	
	public Cliente(int id_cli, String dni_cli, String nom_cli, String ape_cli, String direc_cli, String telef_cli,
			int estado_cli) {
		
		this.id_cli = id_cli;
		this.dni_cli = dni_cli;
		this.nom_cli = nom_cli;
		this.ape_cli = ape_cli;
		this.direc_cli = direc_cli;
		this.telef_cli = telef_cli;
		this.estado_cli = 1;
	}

	public Cliente(int id_cli, String dni_cli, String nom_cli, String ape_cli, String direc_cli, String telef_cli) {
		this.id_cli = id_cli;
		this.dni_cli = dni_cli;
		this.nom_cli = nom_cli;
		this.ape_cli = ape_cli;
		this.direc_cli = direc_cli;
		this.telef_cli = telef_cli;
		this.estado_cli = 1;
	}

	public Cliente() {
		
	}
	
	public int getId_cli() {
		return id_cli;
	}
	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}
	public String getDni_cli() {
		return dni_cli;
	}
	public void setDni_cli(String dni_cli) {
		this.dni_cli = dni_cli;
	}
	public String getNom_cli() {
		return nom_cli;
	}
	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}
	public String getApe_cli() {
		return ape_cli;
	}
	public void setApe_cli(String ape_cli) {
		this.ape_cli = ape_cli;
	}
	public String getDirec_cli() {
		return direc_cli;
	}
	public void setDirec_cli(String direc_cli) {
		this.direc_cli = direc_cli;
	}
	public String getTelef_cli() {
		return telef_cli;
	}
	public void setTelef_cli(String telef_cli) {
		this.telef_cli = telef_cli;
	}
	public int getEstado_cli() {
		return estado_cli;
	}
	public void setEstado_cli(int estado_cli) {
		this.estado_cli = estado_cli;
	}
		
}
