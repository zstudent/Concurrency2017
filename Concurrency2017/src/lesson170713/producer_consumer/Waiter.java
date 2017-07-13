package lesson170713.producer_consumer;

import java.util.concurrent.BlockingQueue;

import lesson170310.Utils;

class Waiter implements Runnable {
	
	private BlockingQueue<String> window;

	public Waiter(BlockingQueue<String> window) {
		this.window = window;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println("start waiting");
			try {
				String dish = window.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("serving");
			Utils.pause(10000 + SynchQueueExample.random.nextInt(3000));
		}
	}

}