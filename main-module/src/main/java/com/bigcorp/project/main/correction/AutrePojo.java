package com.bigcorp.project.main.correction;

public class AutrePojo {

	private Integer id;

	private String nom;

	private Boolean actif;

	public AutrePojo() {
	}

	public AutrePojo(Integer id, String nom, Boolean actif) {
		this.id = id;
		this.nom = nom;
		this.actif = actif;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

}
