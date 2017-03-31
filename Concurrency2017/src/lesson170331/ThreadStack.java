package lesson170331;


public class ThreadStack {

	public static void main(String[] args) {
		
		a();
		
	}

	private static void a() {
		a();
	}
	
}
