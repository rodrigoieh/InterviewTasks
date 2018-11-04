package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMaxDivision {
	
/**
 * 	
 * @param args
 */

	public static void main(String[] args) {

        int[] a = { 1,3,-3 };
//      int[] a = { 4, 3, 2, 5, 1, 1 };
//       int[] a = { 4, 3, 2, 5, 1, -4,-7,7,6,3,5 };
        
        int domax = getDivisionOnMaximumParts(a);
        System.out.println("doMax = " + domax);

	}

    static int getDivisionOnMaximumParts(int[] a) {

        List<Integer> allMax = new ArrayList<>();

        for (int i = 1; i <= a.length - 1; i++) {
            
            int[] b = Arrays.copyOfRange(a, 0, i);
            int[] c = Arrays.copyOfRange(a, i, a.length);
            
            int bmax = Arrays.stream(b).max().getAsInt();
            int cmax = Arrays.stream(c).max().getAsInt();

            int division = bmax - cmax;
            if (division < 0)
                division = division * (-1);

            allMax.add(new Integer(division));
        }
        return allMax.stream().max(Integer::compare).get();
    }
	
}
