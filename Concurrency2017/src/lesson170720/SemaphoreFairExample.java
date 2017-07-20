package lesson170720;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import lesson170310.Utils;

public class SemaphoreFairExample {

	private static final class Runner implements Runnable {
		private Semaphore sem;

		public Runner(Semaphore sem) {
			this.sem = sem;
		}

		@Override
		public void run() {
			int number = count++;
			System.out.println(number + "waiting for signal");
			sem.acquireUninterruptibly();
			System.out.println(number + " got signal");
		}
	}

	static volatile int count = 0;

	public static void main(String[] args) {

		Semaphore sem = new Semaphore(0, false);

		List<Runner> runners = Arrays.asList(new Runner(sem), new Runner(sem),
				new Runner(sem), new Runner(sem));

		ExecutorService service = Executors.newCachedThreadPool();
		
		for (Runner runner : runners) {
			Utils.pause(200);
			service.execute(runner);
		}
		
		Utils.pause(500);

		System.out.println("ready...");
		Utils.pause(1000);
		System.out.println("steady...");
		Utils.pause(1000);
		System.out.println("go!");

		for (int i = 0; i < runners.size(); i++) {
			sem.release();
			Utils.pause(100);
		}

	}

}
