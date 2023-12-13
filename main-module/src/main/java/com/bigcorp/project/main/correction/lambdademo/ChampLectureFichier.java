package com.bigcorp.project.main.correction.lambdademo;

public class ChampLectureFichier implements Cliquable {

	@Override
	public String clique(int force) {
		System.out.println("Je lis le fichier demandé");
		return "Fichier lu";
	}

}
