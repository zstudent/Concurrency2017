package lesson170718;

import java.util.concurrent.locks.ReentrantLock;

public class LockUnlockInSeparateThreads {
	
	
	public static void main(String[] args) {
		
		ReentrantLock lock = new ReentrantLock();
		System.out.println(lock.getHoldCount());
		
		
		lock.lock();
		System.out.println(lock.getHoldCount());

		lock.lock();
		System.out.println(lock.getHoldCount());
		
		new Thread( () -> {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			} else {
				System.out.println("I can't do it!");
			}
		}).start();
		
		
	}

}
