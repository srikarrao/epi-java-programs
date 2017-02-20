package com.eop.java.programs.parallelcomputing;

public class ThreadSynchronizationA {

	private static int N = 0;
	private static int counter = 0;

	private static class ThreadInterLeaved implements Runnable {

		@Override
		public void run() {
			// synchronized (this) {
				for (int i = 0; i < N; i++) {
					counter++;
				}
				System.out.println(counter);
			//}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		N = 10000;
		ThreadInterLeaved tLeaved = new ThreadInterLeaved();
		Thread t1 = new Thread(tLeaved);
		Thread t2 = new Thread(tLeaved);
		t1.start();
		// Thread.sleep(10000);
		t2.start();
		 t1.join();
		 t2.join();
	}
}