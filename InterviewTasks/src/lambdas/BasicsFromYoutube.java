package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/**
 * https://www.youtube.com/watch?v=t1-YZ6bF-g0
 */
public class BasicsFromYoutube {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BasicsFromYoutube bfy = new BasicsFromYoutube();
		
//      IntStream.range(1,8).skip(2).forEach(System.out::println);
//      System.out.println(IntStream.range(1,5).sum());
		
      Stream.of("WABC","Telus","Capgemini").sorted().findFirst().ifPresent(System.out::println);
      
//      Stream.of(263,49,59,23).sorted().findFirst().ifPresent(System.out::println);

		String[] deps = { "Telus", "Capgemini", "Mackenzie Investments" };
		Arrays.stream(deps).sorted().forEach(System.out::println);

		//6. Average if squares of an int array
		Arrays.stream(new int[] {2,4,6,8,10})
		.map(t -> t * t)
		.average()
		.ifPresent(System.out::println);
		
		OptionalDouble y = Arrays.stream(new int[] {2,4,6,8,10})
		.map(t -> t * t)
		.average();
		System.out.println("OptionalDouble y = " + y.getAsDouble());
		
		int su = Arrays.stream(new int[] {2,4,6,8,10})
				.map(t -> t * t)
				.sum();
				
				System.out.println("Sum su = " + su);
		
		
		bfy.ListSkipQ42();
		
	}
	
	public void ListSkipQ42() {
        List<Integer> numbers=Arrays.asList(1,2,3,4,5);
        List<Integer> result = numbers.stream().skip(2)
            .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(result.toString());
	}
}
