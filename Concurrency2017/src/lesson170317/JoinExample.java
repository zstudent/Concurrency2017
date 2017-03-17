package lesson170317;

import lesson170310.Utils;

public class JoinExample {
	
	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("start");
			Utils.pause(30000);
			System.out.println("finish");
		}
		
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Task());
		thread.start();
		System.out.println("thread started");
		try {
			thread.join(25000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end");
		Utils.pause(10000);
	}

}
