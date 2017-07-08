package lesson170705;

public class Counter {
	
	private int count;
	private Object lock = new Object();

	 public int getCount() {
		 synchronized (lock) {
			 return count;
		}
	}

	public void inc() {
		synchronized (lock) {
			count++;
		}
	}
	
}
