package lesson170713;

import lesson170310.Utils;

public class UseWorkerWIthPoisonPill {
	
	static class Task implements Runnable {
		
		private int number;

		public Task(int number) {
			this.number = number;
		}
		
		@Override
		public void run() {
			System.out.println("start " + number);
			Utils.pause(2000);
			System.out.println("stop " + number);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		WorkerThreadWithPoisonPill worker = new WorkerThreadWithPoisonPill();
		
		worker.submit(new Task(1));
		worker.submit(new Task(2));
		worker.submit(new Task(3));
		worker.shutdown();
		System.out.println("finished tasks planning");
		
	}

}
