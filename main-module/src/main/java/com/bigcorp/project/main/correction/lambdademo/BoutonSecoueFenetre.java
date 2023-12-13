package com.bigcorp.project.main.correction.lambdademo;

public class BoutonSecoueFenetre implements Cliquable {

	@Override
	public String clique(int force) {
		force = Math.min(10, force);
		force = Math.max(0, force);
		return "Il faut secouer la fenêtre avec la force : " + force;
	}

}
