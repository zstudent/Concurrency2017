package lesson170317;

import lesson170310.Utils;

public class InterruptExample {
	
	static class Task implements Runnable {

		@Override
		public void run() {
			long count = 0;
			while (true) {
				count++;
				if (Thread.interrupted()) {
					System.out.println(count);
				}
				Thread.currentThread().isInterrupted();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new Task());
		thread.start();
		
		while (true) {
			Utils.pause(1000);
			thread.interrupt();
		}
	}

}
