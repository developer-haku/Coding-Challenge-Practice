import java.util.Arrays;
import java.util.HashSet;

public class P0043 {
    private static final int[] div = { 2, 3, 5, 7, 11, 13, 17 };
    private static long sum = 0;

    public static void main(String[] args) {

        // start with d2d3d4
        for (int i = 12; i < 999; i += 2) {
            if (isPanDigit(i)) {
                // init set with numbers
                HashSet<Integer> digitSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
                // d2 = 0 if i < 100
                if (i < 100) {
                    digitSet.remove(0); // remove 0(d2)
                    int k = i; // copy of current num
                    for (int j = 0; j < 2; j++) {
                        digitSet.remove(k % 10); // remove all other digit from the set
                        k /= 10;
                    }
                    checkNext(i, 1, digitSet, "0" + i); // check the set digit
                } else {
                    int k = i;
                    for (int j = 0; j < 3; j++) {
                        digitSet.remove(k % 10);
                        k /= 10;
                    }
                    checkNext(i, 1, digitSet, "" + i);
                }
            }
        }
        System.out.println(sum);
    }

    // set to check 3 digit for this question only
    public static boolean isPanDigit(int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (!set.add(n % 10))
                return false;
            n /= 10;
        }
        return true;
    }

    /**
     * 
     * @param n      current digit
     * @param d      check prime divisors position of the div array
     * @param unused digit set with unused digits
     * @param holder holder string for the number, keep concatenating the next digit
     */
    public static void checkNext(int n, int d, HashSet<Integer> unused, String holder) {
        // found if all prime divisors are checked
        if (d == 7) {
            // the last left digit in the set is d1, concat to the head of the holder string
            sum += Long.parseLong(unused.toArray()[0] + holder);
            return;
        }
        for (Integer integer : unused) {
            int next = n % 100 * 10 + integer; // check next 3 digits number
            if (next % div[d] == 0) {
                HashSet<Integer> digitSet = new HashSet<>(unused);
                digitSet.remove(integer);
                checkNext(next, d + 1, digitSet, holder + integer);
            }
        }
    }
}