package com.bigcorp.project.main.correction;

public class Child {

	private String nom;

	private Integer age;
	
	public Child() {
		
	}

	public Child(String nom, Integer age) {
		this.nom = nom;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Child [nom=" + nom + ", age=" + age + "]";
	}
	
	public Child joueAPierreFeuilleCiseaux(Child other) {
		System.out.println(this.nom + " joue à pierre feuilles ciseaux avec " + other.nom);
		Child vainqueur = Math.random() > 0.5 ? this:other;
		System.out.println(vainqueur.nom + " a gagné ! ");
		return vainqueur;
	}
	
	

}
