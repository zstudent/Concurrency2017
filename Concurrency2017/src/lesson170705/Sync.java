package lesson170705;

import lesson170310.Utils;

public class Sync {

//	static void change() {
//		synchronized (Sync.class) {
//			for (int i = 0; i < 10; i++) {
//				System.out.println(Thread.currentThread().getName() + "  " + i);
//				Utils.pause(1000);
//			}
//		}
//	}

	void change() {
//		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "  " + i);
				Utils.pause(1000);
			}
//		}
	}

	
	public static void main(String[] args) {

		Sync sync = new Sync();
		
		new Thread(() -> {
			sync.change();
		}).start();

		sync.change();
	}

}
