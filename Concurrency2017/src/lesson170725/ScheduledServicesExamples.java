package lesson170725;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lesson170310.Utils;

public class ScheduledServicesExamples {
	
	static int count = 0;
	
	static class Task implements Runnable {

		int number = count++;

		@Override
		public void run() {
			Utils.pause(2000);
			System.out.println(number);
		}
		
	}
	
	public static void main(String[] args) {
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		
		List<Task> tasks = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			tasks.add(new Task());
		}
		
		Iterator<Task> iterator = tasks.iterator();
		
		service.scheduleWithFixedDelay(() -> {
			iterator.next().run();
		}, 0, 3, TimeUnit.SECONDS);
		
//		service.scheduleWithFixedDelay(() -> {
//			System.out.println("one");
//		}, 0, 1, TimeUnit.SECONDS);
		
	}

}
