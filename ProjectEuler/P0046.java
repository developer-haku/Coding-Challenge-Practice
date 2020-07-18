import java.util.ArrayList;

public class P0046 {

    private static ArrayList<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) {
        int smallest = Integer.MAX_VALUE;

        // init a prime list
        soe(1_000_000);

        // http://oeis.org/wiki/Odd_composites Triangle generate
        int jLimit = 0;

        // i = row, j = column
        for (int i = 1; true; i++) {
            for (int j = 1; j <= (jLimit == 0 ? i : jLimit); j++) { // when jLimit is not set, keep looping to the end
                int n = (i * 2 + 1) * (j * 2 + 1); // triange formula
                if (n > smallest) { // exceed current smallest composite number
                    if (jLimit == 1) { // if jLimit = 1 means hit the bottom of first column, stop the program
                        System.out.println(smallest); // print the result
                        return; // stop
                    }
                    jLimit = j - 1; // shrink jLimit
                    break; // exceed the smallest, don't need to check this column anymore, reason of shrink jLimit
                }
                if (!check(n)) {
                    smallest = n; // update smallest
                    jLimit = j - 1; // set the jLimit to the column that found the current smallest
                }
            }
        }

    }

    // conjecture check
    public static boolean check(long n) {
        for (Integer primeNum : primeList) {
            if (primeNum > n)
                break;

            double sqrt = Math.sqrt((n - primeNum) / 2);

            if (sqrt - Math.floor(sqrt) == 0.0)
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

        for (int i = 3; i <= n; i++) {
            if (prime[i] == true)
                primeList.add(i);
        }
    }
}
