package lesson170713.producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import lesson170310.Utils;

class Cook implements Runnable {
	
	private BlockingQueue<String> window;

	public Cook(BlockingQueue<String> window) {
		this.window = window;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("start cooking");
			Utils.pause(1000 + SynchQueueExample.random.nextInt(3000));
			System.out.println("dish is ready, waiting for waiter");
			try {
				window.put("dish");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}