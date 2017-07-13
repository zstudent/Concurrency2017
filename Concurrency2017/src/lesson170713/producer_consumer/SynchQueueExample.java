package lesson170713.producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import lesson170310.Utils;

public class SynchQueueExample {

	static final Random random = new Random();

	public static void main(String[] args) {

		// SynchronousQueue<String> window = new SynchronousQueue<>();
		BlockingQueue<String> window = new LinkedBlockingQueue<>();

		Cook cook = new Cook(window);

		Waiter waiter = new Waiter(window);

		ExecutorService service = Executors.newCachedThreadPool();

		service.execute(cook);
		service.execute(waiter);
		service.execute(new Waiter(window));

		service.execute(() -> {
			while (true) {
				Utils.pause(1000);
				System.out.println(window.size());
				if (window.size() > 2) {
					service.execute(new Waiter(window));
				}
			}
		});

	}

}
