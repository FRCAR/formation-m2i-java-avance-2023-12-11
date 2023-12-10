package com.bigcorp.project.main.concurrent.tp;

import java.util.List;
import java.util.Random;

/**
 * Runnable qui simule un voyage en train aléatoire.
 * 
 */
public class VoyageEnTrainAleatoire implements Runnable {

	private List<LigneFerroviaire> lignesFerroviaires;
	private List<Train> trains;

	public VoyageEnTrainAleatoire(List<Train> trains, List<LigneFerroviaire> lignesFerroviaires) {
		this.trains = trains;
		this.lignesFerroviaires = lignesFerroviaires;
	}

	/**
	 * Prend un train au hasard dans la liste des trains,
	 * une LigneFerroviaire au hasard dans la liste des lignes
	 * ferroviaires, et fait passer le train sur la ligne.
	 */
	@Override
	public void run() {
		Train train = trains.get(new Random().nextInt(trains.size()));
		LigneFerroviaire ligneFerroviaire = lignesFerroviaires.get(new Random().nextInt(lignesFerroviaires.size()));
		train.rouleSur(ligneFerroviaire);
	}

}
