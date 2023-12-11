package com.bigcorp.project.main.correction.tp;

import java.util.concurrent.TimeUnit;

public class Train {

	private String nom;

	public Train(String nom) {
		this.nom = nom;
	}

	public void rouleSur(LigneFerroviaire ligneFerroviaire) {
		ligneFerroviaire.ajoute(this);
		// Le train roule, ce qui prend du temps.
		// On devrait calculer ce temps en fonction de la longueur de la
		// voie et de la vitesse du train ...
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			throw new RuntimeException("Problème de concurrence.", e);
		}
		ligneFerroviaire.enleve(this);
	}

	public String getNom() {
		return nom;
	}

}
