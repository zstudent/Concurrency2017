package lesson170711;

import java.util.Arrays;
import java.util.List;

import lesson170310.Utils;

public class StarterExample {

	static class Runner implements Runnable {

		private Object pager;

		public Runner(Object pager) {
			this.pager = pager;
		}

		@Override
		public void run() {
			synchronized (pager) {
				try {
					pager.wait();
					System.out.println("woke up");
//					Utils.pause(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Running " + this);
		}

	}

	public static void main(String[] args) {

		System.out.println("begin");
		
		Object starter = new Object();

		List<Runner> runners = Arrays.asList(new Runner(starter),
				new Runner(starter), new Runner(starter));
		
		for (Runner runner : runners) {
			new Thread(runner).start();
		}
		
		Utils.pause(1000);
		System.out.println("Ready...");
		Utils.pause(1000);
		System.out.println("Steady...");
		Utils.pause(1000);
		System.out.println("Go!");
		
		synchronized (starter) {
			starter.notifyAll();
		}

	}

}
