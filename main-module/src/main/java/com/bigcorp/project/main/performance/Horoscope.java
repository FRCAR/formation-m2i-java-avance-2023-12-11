package com.bigcorp.project.main.performance;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Horoscope {

	private String[] sentencePart1 = { "Vous allez ", "Il faudra ", "Ne tentez pas de " };
	private String[] sentencePart2 = { " manger ", " réveiller ", " saluer " };
	private String[] sentencePart3 = { " un oeuf au plat.", " un gladiateur.", " une chaise de bureau" };

	private Map<LocalDate, String> horoscopes = new HashMap<>();

	public void generateHoroscope(LocalDate day) {
		cleanHoroscope();
		this.horoscopes.put(day, generateSentence());
	}

	private String generateSentence() {
		String sentence1 = this.sentencePart1[(int) (Math.random() * 3)];
		String sentence2 = this.sentencePart2[(int) (Math.random() * 3)];
		String sentence3 = this.sentencePart3[(int) (Math.random() * 3)];
		return sentence1 + sentence2 + sentence3;
	}

	/**
	 * Nettoie la map horoscopes en mettant toutes les chaînes de caractère à null
	 */
	public void cleanHoroscope() {
		if (this.horoscopes.size() == 7) {
			for (String sentenceString : this.horoscopes.values()) {
				sentenceString = null;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Appuyer sur entrée pour démarrer la génération");
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.nextLine();
			LocalDate date = LocalDate.now();
			Horoscope horoscope = new Horoscope();
			int i = 0;
			while (true) {
				horoscope.generateHoroscope(date);
				date = date.plusDays(1);
				// Le code qui suit sert à faire crasher la
				// JVM moins vite
				// et à faire travailler le garbage collector
				UUID dummy1 = UUID.randomUUID();
				UUID dummy2 = UUID.randomUUID();
				UUID dummy3 = UUID.randomUUID();
				i++;
				if (i == 1_000) {
					Thread.sleep(1);
					i = 0;
				}
			}
		}
	}

}