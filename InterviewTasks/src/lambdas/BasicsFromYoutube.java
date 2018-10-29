package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/**
 * https://www.youtube.com/watch?v=t1-YZ6bF-g0
 */
public class BasicsFromYoutube {

	public static void main(String[] args) {
		
		BasicsFromYoutube bfy = new BasicsFromYoutube();
		
//      IntStream.range(1,8).skip(2).forEach(System.out::println);
//      System.out.println(IntStream.range(1,5).sum());
		
      Stream.of("WABC","Telus","Capgemini").sorted().findFirst().ifPresent(System.out::println);
      
//      Stream.of(263,49,59,23).sorted().findFirst().ifPresent(System.out::println);

		String[] deps = { "Telus", "Capgemini", "Mackenzie Investments" };
		Arrays.stream(deps).sorted().forEach(System.out::println);

		
		bfy.ListSkipQ42();
		
	}
	
	public void ListSkipQ42() {
        List<Integer> numbers=Arrays.asList(1,2,3,4,5);
        List<Integer> result = numbers.stream().skip(2)
            .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(result.toString());
	}
}
