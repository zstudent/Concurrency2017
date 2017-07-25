package lesson170725;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import lesson170310.Utils;

public class AtomicExamples {

	static AtomicInteger count = new AtomicInteger();

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();

		Runnable command = () -> {
			while (true) {
				int c = count.incrementAndGet();
				System.out.println(Thread.currentThread().getName() + " " + c);
				Utils.pause(1000);
			}
		};

		service.execute(command);

		service.execute(command);

	}

}
