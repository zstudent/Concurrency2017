package lesson170725;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lesson170310.Utils;

public class FutureExamples {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Future<?> f1 = service.submit(() -> {
			System.out.println("one");
			Utils.pause(1000);
		} );

		Future<?> f2 = service.submit(() -> {
			System.out.println("two");
			Utils.pause(1000);
		} );
		
		Future<?> f3 = service.submit(() -> {
			System.out.println("three");
			Utils.pause(1000);
		} );
		
//		f2.cancel(false);
		
		service.shutdown();
		List<Runnable> tasks = service.shutdownNow();
		
		System.out.println(tasks);
		
	}

}
