package lesson170713;

public class WorkerWithBlockingQueue {

	final private BlockingQueue<Runnable> tasks;
	final private Thread thread;
	volatile private boolean mayAcceptTasks;

	final private Runnable POISON_PILL = () -> {};

	public WorkerWithBlockingQueue() {
		synchronized (POISON_PILL) {
			tasks = new BlockingQueue<>();
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
			Runnable task = tasks.take();
			if (task == POISON_PILL) {
				System.out.println("I am dying!");
				break;
			}
			task.run();
		}
	}

	public boolean submit(Runnable task) {
		synchronized (POISON_PILL) {
			if (!mayAcceptTasks) {
				return false;
			}
			if (task == POISON_PILL) {
				mayAcceptTasks = false;
			}
			tasks.put(task);
			return true;
		}
	}

}
