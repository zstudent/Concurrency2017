package lesson170310;

public class Example05 {
	
	static class Task implements Runnable {
		
		private String name;

		public Task(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			Thread.currentThread().setName(name);
			int count = 0;
			while (true) {
				Utils.pause(1000);
				System.out.println(count++);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		new Thread(new Task("Counter")).start();
		new Thread(new Task("Counter")).start();
		
		
	}

}
