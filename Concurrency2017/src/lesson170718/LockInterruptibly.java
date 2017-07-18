package lesson170718;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lesson170310.Utils;

public class LockInterruptibly {

	final static Lock lock = new ReentrantLock();
	
	static class EvilTask implements Runnable {
		@Override
		public void run() {
			lock.lock();
			while (true) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("start");
		
		new Thread(new EvilTask()).start();
		
		Utils.pause(500);
		
		System.out.println("lock interruptibly");
		
		Thread thread = new Thread( () -> {
			System.out.println("locker started");
			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				System.out.println("interrupted!");
				return;
			}
			System.out.println("got it!");
		});
		thread.start();
		
		Utils.pause(3000);
		
		
		
		
		
	}
	
	
}
