package lesson170331;

import lesson170310.Utils;

public class ThreadCheckingVariable {

	volatile static boolean RUNNING = true;
	
	static class Task implements Runnable {

		@Override
		public void run() {
			long count = 0;
			while (RUNNING) {
				count++;
			}
			System.out.println(count);
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("start");
		Thread t = new Thread(new Task());
		t.start();
		Utils.pause(3000);
		System.out.println("stop");
		RUNNING = false;
	}
	
}
