package lesson170317;

import lesson170310.Utils;

public class DaemonExample {

	static class Counter implements Runnable {

		@Override
		public void run() {
			int count = 0;
			while (true) {
				Utils.pause(1000);
				System.out.println(++count);
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("start");
		Thread thread = new Thread(new Counter());
		thread.setDaemon(true);
		thread.start();
		
		thread.join();
//		Utils.pause(5000);
		System.out.println("stop");
	}
	
}
