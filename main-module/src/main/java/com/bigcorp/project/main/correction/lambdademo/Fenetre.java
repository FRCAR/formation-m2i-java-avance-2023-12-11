package com.bigcorp.project.main.correction.lambdademo;

import java.util.ArrayList;
import java.util.List;

public class Fenetre {
	
	private List<Cliquable> elementsCliquables = new ArrayList<>();
	
	public void clique(int x, int y, int force) {
		if(elementsCliquables.isEmpty()) {
			return;
		}
		String retourClic = elementsCliquables.get(elementsCliquables.size() - 1).clique(force);
		System.out.println("Le clic sur le bouton a rendu : " + retourClic);
	}
	
	public void add(Cliquable cliquable) {
		this.elementsCliquables.add(cliquable);
	}
	

	public static void main(String[] args) {
		Fenetre fenetre = new Fenetre();
		
		fenetre.add(new BoutonFermeture());
		
		fenetre.clique(3, 5, 12);
		
		fenetre.add(new ChampLectureFichier());
		fenetre.clique(3, 5, 2);
		
		fenetre.add(new BoutonSecoueFenetre());
		fenetre.clique(4, 5, 88);
		
		Cliquable cliquableAvecClasseAnonyme = new Cliquable() {
			@Override
			public String clique(int force) {
				force = Math.min(10, force);
				force = Math.max(0, force);
				return "Il faut secouer la fenêtre avec la force : " + force;
			}
		};
		
		fenetre.add(cliquableAvecClasseAnonyme);
		fenetre.clique(4, 5, 88);
		
		String message = "C'est cliqué ! ";
		
		Cliquable cliquableAvecLambdaAvecPlusieursInstructions = (int force) -> {
			int maxForce = 10;
			force = Math.min(maxForce, force);
			force = Math.max(0, force);
			return message;
		};
		
		Cliquable cliquableAvecLambda = (int force) -> {return "C'est bon, c'est cliqué!";};
		Cliquable cliquableAvecLambdaRaccourcie =  force ->  "C'est bon, c'est cliqué!";

		fenetre.add(cliquableAvecLambdaRaccourcie);
		fenetre.clique(4, 5, 88);
		
		fenetre.add((int force) -> {return "C'est bon, c'est cliqué avec la force : " + force;});
		fenetre.clique(4, 5, 6);
		
		fenetre.add((int force) -> {return Integer.toString(force);});
		fenetre.clique(0, 0, 5);
		
		fenetre.add(Integer::toString);
		fenetre.clique(0, 0, 7);
		
	}

}
