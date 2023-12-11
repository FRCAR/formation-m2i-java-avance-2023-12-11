package com.bigcorp.project.main.correction.tp;

import java.util.List;
import java.util.Random;

public class VoyageEnTrainAleatoire implements Runnable {
	
	private List<LigneFerroviaire> lignesFerroviaires;
	private List<Train> trains;


	public VoyageEnTrainAleatoire(List<Train> trains, List<LigneFerroviaire> lignesFerroviaires) {
		this.trains = trains;
		this.lignesFerroviaires = lignesFerroviaires;
	}


	@Override
	public void run() {
		Train train = trains.get(new Random().nextInt(trains.size()));
		LigneFerroviaire ligneFerroviaire = lignesFerroviaires.get(new Random().nextInt(lignesFerroviaires.size()));
		train.rouleSur(ligneFerroviaire);
	}

}
