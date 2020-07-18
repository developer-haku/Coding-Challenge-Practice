import java.util.ArrayList;

public class P0047 {
    private static ArrayList<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) {
        int n = 1_000; // start with prime below with 1000; 2 * 3 * 5 * 7 = 210, 210 < 1000
        int limit = 210 * 1_000;

        soe(n); // init prime list

        OUTER: for (int i = 210; true; i++) { // keep looping till found it
            if (i > limit) {
                limit *= 1_000;
                primeList = null; // reset
                soe(n); // update prime list
            }
            if (distPrimeCheck(i, i, 0, 0, i / 2)) { // check current num
                for (int j = i + 3; j > i; j--) { // check the 4th digit first
                    if (!distPrimeCheck(j, j, 0, 0, j / 2)) {
                        i = j; // skip to j
                        continue OUTER;
                    }
                }
                System.out.println(i);
                return;
            }
        }
    }

    /**
     * 
     * @param originalNum   origianl number that need to check prime factors
     * @param remain        remain value after divided by the previous prime number
     * @param count         current number of prime factors found
     * @param startingPoint starting point the the next prime in the list
     * @param limit         largest factor limit
     * @return
     */
    public static boolean distPrimeCheck(int originalNum, int remain, int count, int startingPoint, int limit) {
        if (primeList.contains(originalNum))
            return false;

        if (count == 4) // found 4 factors
            // return true if there is no more factors (remain = 1) or remain*x = origianl
            return (remain == 1 || originalNum % remain == 0) ? true : false;

        for (int i = startingPoint; i < primeList.size(); i++) {
            if (primeList.get(i) > limit) // factor won't exceed number / 2
                break;

            if (remain % primeList.get(i) == 0)
                if (distPrimeCheck(originalNum, remain / primeList.get(i), count + 1, i + 1, limit))
                    return true;

        }
        return false;
    }

    // Sieve of Eratosthenes
    public static void soe(int n) {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                primeList.add(i);
        }
    }
}