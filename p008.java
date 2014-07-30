package euler;

import java.util.ArrayList;

/** LARGEST PRODUCT IN A SERIES
 *  The four adjacent digits in the 1000-digit number that have
 *  the greatest product are 9 × 9 × 8 × 9 = 5832.
 *              73167176531330624919225119674426574742355349194934
 *              96983520312774506326239578318016984801869478851843
 *              85861560789112949495459501737958331952853208805511
 *              12540698747158523863050715693290963295227443043557
 *              66896648950445244523161731856403098711121722383113
 *              62229893423380308135336276614282806444486645238749
 *              30358907296290491560440772390713810515859307960866
 *              70172427121883998797908792274921901699720888093776
 *              65727333001053367881220235421809751254540594752243
 *              52584907711670556013604839586446706324415722155397
 *              53697817977846174064955149290862569321978468622482
 *              83972241375657056057490261407972968652414535100474
 *              82166370484403199890008895243450658541227588666881
 *              16427171479924442928230863465674813919123162824586
 *              17866458359124566529476545682848912883142607690042
 *              24219022671055626321111109370544217506941658960408
 *              07198403850962455444362981230987879927244284909188
 *              84580156166097919133875499200524063689912560717606
 *              05886116467109405077541002256983155200055935729725
 *              71636269561882670428252483600823257530420752963450
 * Find the thirteen adjacent digits in the 1000-digit number that have
 * the greatest product. What is the value of this product?
 * @author Michelle Lin
 */

// NON-WORKING; USING DP MAY SPEED UP COMPUTATION

// Greatest product should not have 0 as a multiplier; split on 0s
public class p008 {

    /** 1000-digit number provided as basis for the problem. */
    private static final String NUMBER = "73167176531330624919225119674426574742355349194934"
                                         + "96983520312774506326239578318016984801869478851843"
                                         + "85861560789112949495459501737958331952853208805511"
                                         + "12540698747158523863050715693290963295227443043557"
                                         + "66896648950445244523161731856403098711121722383113"
                                         + "62229893423380308135336276614282806444486645238749"
                                         + "30358907296290491560440772390713810515859307960866"
                                         + "70172427121883998797908792274921901699720888093776"
                                         + "65727333001053367881220235421809751254540594752243"
                                         + "52584907711670556013604839586446706324415722155397"
                                         + "53697817977846174064955149290862569321978468622482"
                                         + "83972241375657056057490261407972968652414535100474"
                                         + "82166370484403199890008895243450658541227588666881"
                                         + "16427171479924442928230863465674813919123162824586"
                                         + "17866458359124566529476545682848912883142607690042"
                                         + "24219022671055626321111109370544217506941658960408"
                                         + "07198403850962455444362981230987879927244284909188"
                                         + "84580156166097919133875499200524063689912560717606"
                                         + "05886116467109405077541002256983155200055935729725"
                                         + "71636269561882670428252483600823257530420752963450";

    /** Number of adjacent digits used to form product. */
    private static final long DIGITS = 13;

    public static void main(String[] ignored) {
        ArrayList<String> filtered = checkLength(splitOnZeros(NUMBER));
        System.out.printf("The product is %d\n", greatestProduct(filtered));
    }

    /** Returns an array of substrings of STR, split on the '0' character. */
    public static String[] splitOnZeros(String str) {
        return str.split("0");
    }

    /** Returns a list of substrings filtered by the appropriate number of digits. */
    public static ArrayList<String> checkLength(String[] arr) {
        ArrayList<String> lst = new ArrayList<String>();
        for (String str : arr) {
            if (str.length() >= DIGITS) {
                lst.add(str);
                System.out.println(str);
            }
        }
        return lst;
    }

    /** Returns the greatest product found by multiplying DIGIT adjacent digits. */
    public static long greatestProduct(ArrayList<String> lst) {
        long product = 0;
        for (String str : lst) {
            product = Math.max(product, findProduct(str));
        }
        return product;
    }

    /** Returns the largest product of DIGIT adjacent numbers in STR. */
    public static long findProduct(String str) {
        System.out.printf("String is %s\n", str);
        long maxProduct = 1;
        for (int offset = 0; offset < str.length() - DIGITS; offset += 1) {
            long product = 1;
            for (int i = 0; i < DIGITS; i += 1) {
                System.out.printf("Product is %d\n", product);
                product *= Character.getNumericValue(str.charAt(i + offset));
            }
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }
}
