package lambdas;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=t1-YZ6bF-g0
 */
public class BasicsFromYoutube {

	public static void main(String[] args) {

		String[] deps = { "Telus", "Capgemini", "Mackenzie Investments" };
		Arrays.stream(deps).sorted().forEach(System.out::println);

	}

}
