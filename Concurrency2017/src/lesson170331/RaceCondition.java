package lesson170331;

import lesson170310.Utils;

public class RaceCondition {

	static int count = 0;
	
	static class Task implements Runnable {

		@Override
		public void run() {
			while (true) {
				Utils.pause(3000);
				inc2();
			}
		}

		synchronized private void inc() {
//			synchronized (this) {
				count++;
				System.out.println(count);
//			}
		}
		
		private void inc2() {
				count++;
				System.out.println(count);
		}
		
	}
	
	public static void main(String[] args) {
		Task target = new Task();
		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);
		
		t1.start();
		t2.start();
		
	}
	
}
