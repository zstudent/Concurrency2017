package lesson170705;

import lesson170310.Utils;

public class EvilCounterUsage {

	public static void main(String[] args) {
		
		Counter c = new Counter();
		
		System.out.println("starting evil thread");
		
		new Thread(() -> {
			synchronized (c) {
				while(true) {}
			}
		}).start();
		
		Utils.pause(1000);
		
		System.out.println("starting good threads");
		
		new Thread(() -> {
			while (true) {
				c.inc();
				Utils.pause(1000);
			}
		}).start();
		
		new Thread(() -> {
			while (true) {
				System.out.println(c.getCount());
				Utils.pause(1000);
			}
		}).start();
		
	}
	
}
