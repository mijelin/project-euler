import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  LARGEST PRIME FACTOR
 *  The prime factors of 13195 are 5, 7, 13 and 29.
 *  What is the largest prime factor of the number 600851475143?
 *  @author Michelle Lin
 */

public class p003 {

    private static final long NUM = 600851475143L;

    /** Runs prime factorization algorithm and returns the largest factor. */
    public static void main(String[] ignored) {
        Comparator<Long> c = reverseOrder();
        PriorityQueue<Long> queue = new PriorityQueue<Long>(10, c);
        factor(queue, NUM);
        System.out.printf("The largest prime factor of %d is %d\n", NUM, queue.poll());
    }

    /** Returns the prime factorization of N, descending. */
    private static void factor(PriorityQueue<Long> queue, long n) {
        queue.add(n);
        while (!isPrime(queue.peek())) {
            long factor = 2;
            while (!(queue.peek() % factor == 0)) {
                factor += 1;
            }
            long num = queue.poll();
            queue.add(num / factor); queue.add(factor);
        }
    }

    /** Returns true iff N is prime. */
    private static boolean isPrime(int n) {
        if (n == 2) { return true; }
        int upperBound = (int) Math.ceil(Math.sqrt((double) n));
        for (int i = 2; i <= upperBound; i += 1) {
            // possible speedup by sieving through factors here?
            if (n % i == 0) { return false; }
        }
        return true;
    }

    /** Returns a comparator ordering elements from highest to lowest. */
    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return new Comparator<T>() {
            @Override
            public int compare(T x, T y) {
                return x.compareTo(y) * -1;
            }
        };
    }
}
