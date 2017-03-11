package lesson170310;

public class Example01 {

	public static void main(String[] args) {

		Thread currentThread = Thread.currentThread();

		System.out.println(currentThread.getName());
		System.out.println(currentThread.getThreadGroup().getName());

		Thread thread = new Thread(() -> {
			System.out.println("hello");
			System.out.println(Thread.currentThread().getName());
			System.out
					.println(Thread.currentThread().getThreadGroup().getName());
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("finished");
		});
		thread.start();

		System.out.println("main: finish");
		
	}

}
