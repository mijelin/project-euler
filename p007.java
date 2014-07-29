import java.util.Arrays;

/** 10001ST PRIME
 *  By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *  What is the 10,001st prime number?
 *  @author Michelle Lin
 */
 
 public class p007 {
 
    /** Holds primes before N with which to sieve. */
    private static int[] primes;
 
    /** Returns the Nth prime number (N as user input). */
    public static void main(String[] args) {
        int n;
        try {
            n = Integer.parseInt(args[0]);
            primes = new int[n];
            System.out.printf("Prime #%d is %d\n", n, prime(n));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Argument should be an integer.");
        }
    }

    /** Populates the array of the first N primes and returns the Nth prime. */
    private static int prime(int n) {
        int index = 0; int num = 2;
        while (index < primes.length) {
            if (isPrime(num)) {
                primes[index] = num;
                index += 1;
            }
            num += 1;
        }
        return primes[n - 1];
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
}
