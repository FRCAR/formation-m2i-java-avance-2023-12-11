package com.bigcorp.project.main.concurrent;

/**
 * Méthode synchronisée ou non synchronisée.
 * A appeler en debug avec un point d'arrêt dans la méthode.
 */
public final class SynchronizedMethod {

	public synchronized int synchronizedMethod() {
		System.out.println("Début méthode");
		System.out.println("Fin méthode");
		return 423;
	}

	
	public static void main(String[] args) {
		SynchronizedMethod newInstance = new SynchronizedMethod();
		System.out.println("Début du main");
		Runnable otherRunnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Début du runnable");
				newInstance.synchronizedMethod();
			}
		};
		
		Thread otherThread = new Thread(otherRunnable);
		otherThread.start();
		System.out.println("Fin du main");
		
	}

}