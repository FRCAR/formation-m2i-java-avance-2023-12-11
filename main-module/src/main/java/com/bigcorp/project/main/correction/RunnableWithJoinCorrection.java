package com.bigcorp.project.main.correction;

public class RunnableWithJoinCorrection implements Runnable {
	
	private String maValeur;
	
	/**
	 * 
	 * Créer une classe qui implémente Runnable, qui contient une variable
	 * d’instance, accessible par un getter. Le run() de ce Runnable attend 5
	 * secondes, puis met une valeur dans une variable d’instance. Le thread
	 * principal lance un nouveau thread avec ce Runnable, attend qu’il ait fini,
	 * puis récupère et affiche la variable du runnable.
	 */
	@Override
	public void run() {
		System.out.println("Démarrage LongTaskRunnable");
		try {
			Thread.sleep(5_000);
			// TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			return;
		}
		this.maValeur = "Salut !";
		System.out.println("Fin LongTaskRunnable");
	}

	public static void main(String[] args) throws InterruptedException {
		RunnableWithJoinCorrection runnableWithJoinCorrection = new RunnableWithJoinCorrection();
		Thread newThread = new Thread(runnableWithJoinCorrection);
		newThread.start();
		System.out.println("Nouveau thread lancé, le thread main attend");
		newThread.join();
		System.out.println("Apparemment, le new Thread a terminé, la valeur vaut : ");
		System.out.println(runnableWithJoinCorrection.getMaValeur());
	}

	public String getMaValeur() {
		return maValeur;
	}

}
