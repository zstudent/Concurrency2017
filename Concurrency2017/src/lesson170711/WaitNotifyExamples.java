package lesson170711;

import lesson170310.Utils;
import lesson170711.NaiveMessagePassing.Task;

public class WaitNotifyExamples {
	
	static class Task implements Runnable {
		
		private Object pager;

		public Task(Object pager) {
			this.pager = pager;
		}

		@Override
		public void run() {
			synchronized (pager) {
				try {
					pager.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(this);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		Object pager = new Object();
		
		new Thread(new Task(pager)).start();
		
		Utils.pause(30000);
		
		synchronized (pager) {
			pager.notify();
		}
		
		Utils.pause(10000);
		
	}
	

}
