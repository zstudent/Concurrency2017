package lesson170711;

public class SimpleWorker {

	public void process(Runnable task) {
		new Thread(task).start();
	}
	
}
