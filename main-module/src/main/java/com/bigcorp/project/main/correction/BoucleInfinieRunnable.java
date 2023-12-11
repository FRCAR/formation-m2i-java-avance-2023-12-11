package com.bigcorp.project.main.correction;

import java.util.concurrent.TimeUnit;

public class BoucleInfinieRunnable {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Début main");
		LongTaskRunnable longTaskRunnable = new LongTaskRunnable();
		new Thread(longTaskRunnable).start();
		TimeUnit.SECONDS.sleep(1);
		longTaskRunnable.orderStop();
		System.out.println("Fin main");

	}

	private static final class LongTaskRunnable
			implements Runnable {

		private volatile boolean stopOrdered = false;

		public void orderStop() {
			this.stopOrdered = true;
		}
		
		public synchronized boolean isStopOrdered() {
			return stopOrdered;
		}

		@Override
		public void run() {
			System.out.println("Démarrage LongTaskRunnable");
			int i = 0;
			while (!stopOrdered) {
				i++;
			}

			System.out.println("Fin LongTaskRunnable");
		}



		
	}

}
