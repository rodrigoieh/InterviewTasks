package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Run the task to count to 1000 times using 200 threads
 * 
 */
public class Cppib200Threads {

	private final static int NUMBER_OF_THREADS = 200;
	private static AtomicInteger counter = new AtomicInteger(0);
	static List<Integer> r = new ArrayList<>();

	private void increment() {
		synchronized (this) {
			counter.getAndIncrement();
			r.add(new Integer(counter.get()));
			// System.out.println("Counter = " + counter.get());
		}

	}

	public static void main(String[] args) {
		Cppib200Threads ct = new Cppib200Threads();
		ExecutorService service = null;

		try {
			service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

			for (int i = 0; i < 1000; i++) {
					service.submit(() -> ct.increment());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (service != null)
				service.shutdown();
		}
		System.out.println("******************** counter = " + counter.get());

		r.stream().forEach(t -> System.out.println(t));

	}

}
