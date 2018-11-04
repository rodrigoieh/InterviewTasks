package codility;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestSentence {

	public static void main(String[] args) {
		
//		String m = "We test coders. Give us a try?.";
//		String m = "We test coders. Give us a try?";
		String m = "Forget CVs..Save time. x x";
		
		
		int n = solution(m);
		System.out.println("n = " + n);
		
	}
	
	public static int solution (String S) {
		return Arrays.asList(S.split("\\.!?")).stream()
		.collect(Collectors.toMap(Function.identity(), t -> t.trim().split(" ").length))
		.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
	}

}
