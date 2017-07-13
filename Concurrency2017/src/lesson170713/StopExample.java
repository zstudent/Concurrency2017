package lesson170713;

import java.util.Arrays;

import lesson170310.Utils;

public class StopExample {
	
	static class Task implements Runnable {

		
		Object lock = new Object();
		// x + y == 0
		
		int x = 0;
		int y = 0;
		
		@Override
		public void run() {
			synchronized (lock) {
				x += 10;
				Utils.pause(1000);
				y -= 10;
			}
		}
		
		public int[] get() {
			int [] result = new int[2];
			synchronized (lock) {
				result[0] = x;
				result[1] = y;
			}
			return result;
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("start");
		
		Task t = new Task();
		
		Thread thread = new Thread(t);
		thread.start();
		
		Utils.pause(200);
		thread.stop();
		
		System.out.println(Arrays.toString(t.get()));
		
		
	}

}
