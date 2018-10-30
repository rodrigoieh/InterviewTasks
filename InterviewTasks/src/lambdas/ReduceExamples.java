package lambdas;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceExamples {

	public static void main(String[] args) {
		
		doReduceOnDoubles();
		doSummaryStatistics();
		
		
	}
	
	
	public static void doSummaryStatistics() {
		IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10)
				.summaryStatistics();
		System.out.println(summary);
	}
	
	
	/* 13 Reduction - sum*/
	public static void doReduceOnDoubles() {
		double total = Stream.of(3.3,59.0,70.01,75.0,92.0)
				.reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("Total = " + total);
	}

}
