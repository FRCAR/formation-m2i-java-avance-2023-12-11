package com.bigcorp.project.main.correction.lambdademo;

public class BoutonFermeture implements Cliquable {

	@Override
	public String clique(int force) {
		return "Ferme la fenêtre";
	}

}
