package lesson170713;

import java.util.LinkedList;
import java.util.Queue;

public class WorkerThreadWithPoisonPill {

	private Queue<Runnable> tasks = new LinkedList<>();
	private Thread thread;
	volatile private boolean mayAcceptTasks;
	
	static final private Runnable POISON_PILL = () -> {
		Thread.currentThread().stop();
	};
	
	public WorkerThreadWithPoisonPill() {
		synchronized (tasks) {
			thread = new Thread(this::process);
			thread.start();
			mayAcceptTasks = true;
		}
	}
	
	public void shutdown() {
		submit(POISON_PILL);
	}

	private void process() {
		while (true) {
			Runnable task = null;
			synchronized (tasks) {
				while (tasks.isEmpty()) {
					try {
						tasks.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				task = tasks.poll();
			}
//			if (task == POISON_PILL) {
//				System.out.println("I am dying!");
//				break;
//			}
			task.run();
		}
	}
	
	public boolean submit(Runnable task) {
		synchronized (tasks) {
			if (!mayAcceptTasks) {
				return false;
			}
			if (task == POISON_PILL) {
				mayAcceptTasks = false;
			}
			tasks.add(task);
			tasks.notify();
		}
		return true;
	}

}
