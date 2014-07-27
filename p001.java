import java.util.HashSet;
import java.util.Iterator;

/** MULTIPLES OF 3 AND 5
 *  Find the sum of all the multiples of 3 or 5 below 1000.
 *  @author Michelle Lin
 */

// Implemented in Java to take advantage of HashSet data structure
public class p001 {

    private final static int MULT00 = 3;
    private final static int MULT01 = 5;

    private final static int UPPER_BOUND = 1000;

    public static void main (String[] ignored) {
        HashSet<Integer> nums = new HashSet<Integer>();
        multiples(nums, MULT00, UPPER_BOUND);
        multiples(nums, MULT01, UPPER_BOUND);
        System.out.printf("Sum is: %d \n", sum(nums));
    }

    /** Adds all multiples of FACTOR in range [1, UPPERBOUND) to SET. */
    private static void multiples(HashSet<Integer> set, int factor, int upperBound) {
        for (int i = 1; i < upperBound; i += 1) {
            if (i % factor == 0) { set.add(i); }
        }
    }

    /** Returns the contents of all elements in SET. */
    private static int sum(HashSet<Integer> set) {
        int sum = 0;
        if (set.isEmpty()) {
            return sum;
        } else {
            Iterator<Integer> iter = set.iterator();
            while (iter.hasNext()) {
                sum += iter.next();
            }
            return sum;
        }
    }
}
