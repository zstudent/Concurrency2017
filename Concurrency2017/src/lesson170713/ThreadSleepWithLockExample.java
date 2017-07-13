package lesson170713;

import lesson170310.Utils;

public class ThreadSleepWithLockExample {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		Object lock = new Object();
		
		Thread thread = new Thread( () -> {
			synchronized (lock) {
				try {
//					Utils.pause(10000);   BAD
					lock.wait(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Woke up");
			}
			
		});
		thread.start();
		
		Utils.pause(1000);
		
		synchronized (lock) {
			System.out.println("hello");
		}
		
	}
	

}
