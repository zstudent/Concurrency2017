package lesson170317;

public class JoinToDead {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread();
		thread.start();
		thread.join();
		thread.join();
	}
	
}
