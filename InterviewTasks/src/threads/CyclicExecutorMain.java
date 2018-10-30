package threads;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CyclicExecutorMain {
	
	private static final int NUMBER_OF_THREADS = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CyclicBarrier cb = new CyclicBarrier(NUMBER_OF_THREADS);
		ExecutorService service = null;
		
		try {
			service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
			
			Future<Integer> sumFuture = service.submit(() -> {
				int c = 3 + 3; // or fuck yourself to do something more complicated
				cb.await();
				System.out.println("Thread - 1");
				return c;
			});
			
			Future<Integer> diffFuture = service.submit(() -> {
				int g = 45 + 86;
				cb.await();
				System.out.println("Thread - 2");
				return g;
			});
			
			int r1 = sumFuture.get();
			int r2 = diffFuture.get();
			
			System.out.println("r1 = " + r1 + "    r2 = " + r2);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(service != null)
				service.shutdown();
		}
		
	}

}
