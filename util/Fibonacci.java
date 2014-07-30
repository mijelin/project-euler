package euler;

import java.util.HashMap;

/** Fibonacci functions, with fib(0) = 1, as defined by Problem 2.
 *  @author Michelle Lin
 */

public class Fibonacci {

    /** Returns the N-th term (zero-indexed) of the Fibonacci sequence. */
    public static int getFib(int n) {
        return fib(n).get(n);
    }

    /** Returns Fibonacci sequence up to fib(n), with index mapped to values. */
    public static HashMap<Integer, Integer> getFibSeq(int n) {
        HashMap<Integer, Integer> f = new HashMap<Integer, Integer>();
        f.put(0, 1); f.put(1, 1); computeFib(f, n, 2);
        return f;
    }

    /** Computes and stores fib(I) into F, up to the N-th term. */
    private static void computeFib(HashMap<Integer, Integer> f, int n, int i) {
        if (n >= 0) {
            int val = f.get(i - 1) + f.get(i - 2);
            f.put(i, val);
            computeFib(f, n - 1, i + 1);
        }
    }

}
