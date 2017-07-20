package lesson170720;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {

	int count = 0;
	
	Lock lock = new ReentrantLock();
	
	public int get() {
		lock.lock();  // synchronized(lock) {
		try {
			return count;
		} finally {
			lock.unlock();  // }
		}
	}
	
	public void inc() {
		lock.lock();  // synchronized (lock) {
		try {
			count++;
		} finally {
			lock.unlock();  // }
		}
	}
	
}
