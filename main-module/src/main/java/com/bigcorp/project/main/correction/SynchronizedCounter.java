package com.bigcorp.project.main.correction;

public final class SynchronizedCounter {

	private int counter = 0;

	public synchronized int incrementAndGet() {
		System.out.println("Démarrage incrementAndGet");
		counter++;
		System.out.println("Fin incrementAndGet");
		return counter;
	}

	public synchronized int decrementAndGet() {
		System.out.println("Démarrage decrementAndGet");
		counter--;
		System.out.println("Fin decrementAndGet");
		return counter;
	}

	public synchronized int value() {
		return counter;
	}
	
	public static void main(String[] args) {
		SynchronizedCounter counter = new SynchronizedCounter();
		
		Runnable counterManipulator = new Runnable() {
			@Override
			public void run() {
				System.out.println("La valeur du compteur dans l'autre Thread vaut : " + counter.incrementAndGet());
			}
		};
		
		Thread otherThread = new Thread(counterManipulator);
		otherThread.start();
		
		System.out.println("La valeur du compteur dans le main vaut : " + counter.incrementAndGet());
		
	}

}