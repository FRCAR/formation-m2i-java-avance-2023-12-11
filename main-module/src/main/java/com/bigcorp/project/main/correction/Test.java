package com.bigcorp.project.main.correction;

import java.util.ArrayList;
import java.util.List;


/**
 * Crée une outofmemoryError. 
 * A lancer avec -Xms128m -Xmx128m pour ne pas consommer trop de mémoire sur le système
 */
public class Test {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		for(;;) {
			String string = new String("qsedsdqqsdsqd sqd sqd sqdsqdsqd qsd sqd sqd sd sqd sqds");
			list.add(string);
		}

	}

}
