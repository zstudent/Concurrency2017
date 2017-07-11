package lesson170711;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import lesson170310.Utils;

public class ExecutorExamples {
	
	public static void main(String[] args) {
		
		Executor service = Executors.newSingleThreadExecutor();
		
		service.execute(() -> {
			System.out.println("start");
			Utils.pause(2000);
			System.out.println("stop");
		});
		
		service.execute(() -> {
			System.out.println("start");
			Utils.pause(2000);
			System.out.println("stop");
		});
		
		service.execute(() -> {
			System.out.println("start");
			Utils.pause(2000);
			System.out.println("stop");
		});
		
		
	}

}
