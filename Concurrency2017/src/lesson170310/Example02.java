package lesson170310;

public class Example02 {
	
	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("hello");
		}
		
	}
	
	public static void main(String[] args) {
		
		Task task = new Task();
		
		Thread t = new Thread(task);
		t.start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("hello2");
			}
			
		}).start();
		
	}

}
