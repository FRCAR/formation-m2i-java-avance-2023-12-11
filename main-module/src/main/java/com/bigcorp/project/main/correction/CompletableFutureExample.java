package com.bigcorp.project.main.correction;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Créer, via CompletableFuture, un code qui appelle en parallèle deux
 * CompletionStages générant chacun un nombre aléatoire (entre 0 et 1000), puis
 * qui multiplie ces nombres dans un autre CompletionStage.
 */
public class CompletableFutureExample {

	public static void main(String[] args) throws Exception {

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);

		Random random = new Random();

		CompletableFuture<Integer> combinedCf = CompletableFuture.supplyAsync(() -> {
			return random.nextInt(1000);
		}, newFixedThreadPool)
				.thenCombine(CompletableFuture.supplyAsync(() -> {
					return random.nextInt(1000);
				}, newFixedThreadPool),
						(Integer i1, Integer i2) -> {
							int mul = i1 * i2;
							return mul;
						});

		System.out.println("Le résultat vaut : " + combinedCf.get());

	}

}
