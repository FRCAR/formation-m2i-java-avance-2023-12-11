package com.bigcorp.project.main.correction.lambdademo;

import java.util.List;
import java.util.stream.Collectors;

import com.bigcorp.project.main.correction.Child;

public class StreamDemo {

	public static void main(String[] args) {
		List<String> liste = List.of("Salut", "Ca va ?", "Super");

		System.out.println("\nAffichage des éléments de la liste après un tri dans une boucle for");
		for (String string : liste) {
			if (string.length() > 5) {
				System.out.println(string);
			}
		}
		
		System.out.println("\nAffichage des éléments de la liste après un tri dans un stream");
		liste.stream()
				.filter((String s) -> {
					return s.length() > 5;
				})
				.forEach((String s) -> {
					System.out.println(s);
				});
		
		System.out.println("\nAffichage des éléments de la liste après un tri et un map");
		liste.stream()
				.filter(s -> s.length() > 5)
				.map(s -> new Child(s, 12))
				.filter(c -> c.getAge() > 11)
				.forEach(System.out::println);
		
		List<Child> enfants = List.of(new Child("Jeanjean", 2), new Child("Roger", 10));
		
		System.out.println("\nAffichage de la moyenne des âges des enfants");
		double moyenneDesAges = enfants.stream()
				.mapToInt(c -> c.getAge()).average().getAsDouble();
		System.out.println(moyenneDesAges);
		
		List<Child> collect = enfants.stream().filter(c -> c.getAge() > 5).collect(Collectors.toList());
		System.out.println(collect.size());
		
	}

}
