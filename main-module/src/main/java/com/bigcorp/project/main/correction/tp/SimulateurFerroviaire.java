package com.bigcorp.project.main.correction.tp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulateurFerroviaire {

	public static void main(String[] args) throws InterruptedException {
		// On créé plusieurs voies et plusieurs trains
		List<Train> trains = new ArrayList<>();
		trains.add(new Train("TGV-5349"));
		trains.add(new Train("TER-1320"));
		trains.add(new Train("RER-POPY"));

		List<LigneFerroviaire> lignesFerroviaires = new ArrayList<LigneFerroviaire>();
		lignesFerroviaires.add(new LigneFerroviaire("Paris-Montpellier", 1));
		lignesFerroviaires.add(new LigneFerroviaire("Lyon-Marseille", 1));
		lignesFerroviaires.add(new LigneFerroviaire("Perpignan-Bayonne", 1));

		System.out.println("Début de la simulation");
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.execute(new VoyageEnTrainAleatoire(trains, lignesFerroviaires));
		executorService.execute(new VoyageEnTrainAleatoire(trains, lignesFerroviaires));
		executorService.execute(new VoyageEnTrainAleatoire(trains, lignesFerroviaires));
		executorService.execute(new VoyageEnTrainAleatoire(trains, lignesFerroviaires));
		executorService.shutdown();
	

	}

}
