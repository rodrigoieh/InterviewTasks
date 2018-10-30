package lambdas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Objects;
import java.util.function.Function;

public class FileReader {

	public static void main(String[] args) throws IOException {

//		Stream<String> bands = Files.lines(Paths.get("C:\\AV\\Interviews\\RBCKingSt\\InterviewTask.txt"));
//		bands.sorted().filter(x -> x.length() > 13).forEach(System.out::println);

		Stream<String> bands = Files.lines(Paths.get("C:\\AV\\Interviews\\RBCKingSt\\codility.txt"));
	
		
		String s = bands.collect(Collectors.joining());
//		System.out.println("s = " + s);
		
		Arrays.asList(s.split("[\\.!?]"))
		.stream()
		.forEach(System.out::println);
		
		int m2 = Arrays.asList(s.split("[\\.!?]"))
		.stream()
		.distinct()
		.collect( Collectors.toMap( Function.identity(), t -> t.split(" ").length))
		.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
		 
		 System.out.println("Max2 =" + m2);
		 
		 bands.close();
	}

}
