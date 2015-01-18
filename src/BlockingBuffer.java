import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingBuffer {
	private Lock lock = new ReentrantLock();
	private Condition full = lock.newCondition();
	private Condition empty = lock.newCondition();
	private Queue<Integer> queue;
	private int capacity;

	public BlockingBuffer(int capacity) {
		this.capacity = capacity;
		queue = new LinkedList<Integer>();
	}

	public void put(int i) throws Exception {
		lock.lock();
		while (queue.size() == capacity) {
			empty.signalAll();
			full.await();
		}
		queue.add(i);
		System.out.println("push:" + i + " size:" + queue.size());
		lock.unlock();
	}

	public int take() throws Exception {
		int ret;
		lock.lock();
		while (queue.isEmpty()) {
			full.signalAll();
			empty.await();
		}
		ret = queue.poll();
		System.out.println("poll:" + ret + " size:" + queue.size());
		lock.unlock();
		return ret;
	}

	public static void main(String[] args) {
		final BlockingBuffer buffer = new BlockingBuffer(10);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						buffer.put(0);
					} catch (Exception e) {
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						buffer.take();
					} catch (Exception e) {
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
}
