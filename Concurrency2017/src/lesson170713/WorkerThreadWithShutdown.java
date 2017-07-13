package lesson170713;

import java.util.LinkedList;
import java.util.Queue;

public class WorkerThreadWithShutdown {

	private Queue<Runnable> tasks = new LinkedList<>();
	private Thread thread;
	
	public WorkerThreadWithShutdown() {
		thread = new Thread(this::process);
		thread.start();
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				process();
//			}
//		}).start();
	}
	
	public void shutdown() {
//		thread.stop();  BAD!!!
		thread.interrupt();
	}

	private void process() {
		OUTER: while (true) {
			Runnable task = null;
			synchronized (tasks) {
				while (tasks.isEmpty()) {
					try {
						tasks.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						break OUTER;
					}
				}
				task = tasks.poll();
			}
			task.run();
		}
	
		for (Runnable runnable : tasks) {
			runnable.run();
		}
	}
	
	public void submit(Runnable task) {
		synchronized (tasks) {
			tasks.add(task);
			tasks.notify();
		}
	}

}
