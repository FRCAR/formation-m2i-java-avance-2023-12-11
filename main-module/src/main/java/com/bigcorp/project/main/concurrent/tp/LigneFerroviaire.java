package com.bigcorp.project.main.concurrent.tp;

import java.util.HashSet;
import java.util.Set;

/**
 * Une ligne ferroviaire, n'acceptant que 
 * capaciteMax qui roulent en simultané sur elle.
 */
public class LigneFerroviaire {

	private String nom;

	private int capaciteMax;

	private Set<Train> trains = new HashSet<>();

	public LigneFerroviaire(String nom, int capaciteMax) {
		this.nom = nom;
		this.capaciteMax = capaciteMax;
	}

	public String getNom() {
		return nom;
	}

	public void ajoute(Train train) {
		System.out.println("Le train " + train.getNom() + " entre sur la ligne " + this.nom);
		this.trains.add(train);
		if (this.trains.size() > this.capaciteMax) {
			throw new RuntimeException("La voie : " + this.nom + " a dépassé sa capacité maximale ! ");
		}
	}

	public void enleve(Train train) {
		this.trains.remove(train);
		System.out.println("Le train " + train.getNom() + " quitte sur la ligne " + this.nom);

	}

}
