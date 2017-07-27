package lesson170727;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
	
	public static void main(String[] args) {
		
		CompletableFuture<Void> helloworld = CompletableFuture.runAsync(() -> {
			System.out.println("hello");
		}).thenRun(() -> {
			System.out.println("world");
		});
		
		CompletableFuture<Void> привет = CompletableFuture.runAsync(() -> {
			System.out.println("привет");
		} );
		
		
	}

}
