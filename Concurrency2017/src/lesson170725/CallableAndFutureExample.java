package lesson170725;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureExample {
	
	static class Task implements Callable<Double> {

		@Override
		public Double call() throws Exception {
			double result = 0;
			
			for (int i = 0; i < 1000000000; i++) {
				Random r = new Random();
				result += Math.pow(Math.PI, r.nextDouble());
			}
			
			return result;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Future<Double> future = service.submit(new Task());
		
		//  do something else
		
		try {
			Double result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
