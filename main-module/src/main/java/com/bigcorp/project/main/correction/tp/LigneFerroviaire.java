package com.bigcorp.project.main.correction.tp;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class LigneFerroviaire {

	private String nom;

	private int capaciteMax;

	private Set<Train> trains = ConcurrentHashMap.newKeySet();

	private Semaphore semaphore;

	public LigneFerroviaire(String nom, int capaciteMax) {
		this.nom = nom;
		this.capaciteMax = capaciteMax;
		this.semaphore = new Semaphore(capaciteMax, true);
	}

	public String getNom() {
		return nom;
	}

	public void ajoute(Train train) {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			throw new RuntimeException("Problème de concurrence.", e);
		}
		System.out.println("Le train " + train.getNom() + " entre sur la ligne " + this.nom);
		this.trains.add(train);
		if (this.trains.size() > this.capaciteMax) {
			throw new RuntimeException("La voie : " + this.nom + " a dépassé sa capacité maximale ! ");
		}
	}

	public void enleve(Train train) {
		this.trains.remove(train);
		this.semaphore.release();
		System.out.println("Le train " + train.getNom() + " quitte  la ligne " + this.nom);

	}

}
