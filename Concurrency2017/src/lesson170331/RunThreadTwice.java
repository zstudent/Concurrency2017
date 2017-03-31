package lesson170331;

public class RunThreadTwice {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread();
		
		t.start();
		System.out.println(t.getState());
		
		t.join();
		System.out.println(t.getState());
		
		t.start();
		System.out.println(t.getState());
		
	}

}
