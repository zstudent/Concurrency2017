package lesson170310;

public class Example03 {
	
	static class MyThread extends Thread {
		
		@Override
		public void run() {
			System.out.println("hello");
		}
		
	}
	
	public static void main(String[] args) {
		
		new MyThread().start();
		
		
	}

}
