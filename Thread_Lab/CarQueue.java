import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Rui Gao
 *
 */
public class CarQueue {

	Random ran = new Random();
	PriorityQueue<Integer> p = new PriorityQueue<Integer>();
	private int runOut;

	public CarQueue() {

		p.add(ran.nextInt(5));
		p.add(ran.nextInt(5));
		p.add(ran.nextInt(5));
		p.add(ran.nextInt(5));
		p.add(ran.nextInt(5));
		p.add(ran.nextInt(5));
		p.add(ran.nextInt(5));
		p.add(ran.nextInt(5));
		p.add(ran.nextInt(5));
		p.add(ran.nextInt(5));
	}

	/**
	 * 
	 */
	public void addToQueue() {

		class ARunnable implements Runnable {
			public void run() {
				try {
					p.add(ran.nextInt(5));
					p.add(ran.nextInt(5));
					p.add(ran.nextInt(5));
					p.add(ran.nextInt(5));
					p.add(ran.nextInt(5));
					p.add(ran.nextInt(5));
					p.add(ran.nextInt(5));

				} finally {
				}
			}
		}
		Runnable r = new ARunnable();
		Thread t = new Thread(r);
		t.start();
	}


	/**
	 * @return
	 */
	public int deleteQueue() {
		class ARunnable implements Runnable {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}

				try {
					if (p.size() < 15) {
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));
						p.add(ran.nextInt(5));

					} else if (!p.isEmpty()) {
						runOut = p.remove();
					}
				} finally {
				}
			}
		}
		Runnable r = new ARunnable();
		Thread t = new Thread(r);
		t.start();
		return runOut;
	}
}
