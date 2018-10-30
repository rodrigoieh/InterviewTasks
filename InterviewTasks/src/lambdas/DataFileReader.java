package lambdas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DataFileReader {

	public static void main(String[] args) throws IOException {

		showData();
		mapData();
		
	}
	
	
	/**
	 * @throws IOException
	 */
	public static void mapData() throws IOException {
		
		Stream<String> rows = Files.lines(Paths.get("C:/AV/Interviews/RBCKingSt/resultdata.txt"));
		
		Map<Integer, String> map = new HashMap<>();
		
		map = rows.map(t -> t.split(","))
		.filter(t -> t.length == 3)
		.filter(t -> t[2].equals("success"))
		.collect(Collectors.toMap(t -> Integer.parseInt(t[0]), t -> t[1]));
		
		rows.close();
		for(Integer key : map.keySet()) {
			System.out.println(key + "  " + map.get(key));
		}
		
		
		
	}
	
	
	
	public static void showData() throws IOException {
		
		Stream<String> rows = Files.lines(Paths.get("C:/AV/Interviews/RBCKingSt/resultdata.txt"));

//		int m = (int) rows.map(t -> t.split(",")).filter(t -> t.length == 3).count();
//		System.out.println(m);
		
		rows.map(t -> t.split(","))
		.filter(t -> t.length == 3)
		.filter(t -> t[2].equalsIgnoreCase("success"))
		.forEach(t -> System.out.println(t[0] + " " + t[1] + "  " + t[2]));
		rows.close();
	}

}
