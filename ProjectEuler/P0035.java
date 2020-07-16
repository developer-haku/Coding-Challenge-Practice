import java.util.HashSet;

public class P0035 {
    private static HashSet<Integer> primeSet = new HashSet<>();
    private static HashSet<Integer> nonCircularPrimeSet = new HashSet<>();

    public static void main(String[] args) {
        int om = 1_000_000;

        // init prime set
        soe(om);

        for (Integer primeNum : primeSet) {
            HashSet<Integer> holder = new HashSet<>();
            boolean isCircularPrime = true;
            int numLen = (int) (Math.log10(primeNum) + 1);
            int divisor = (int) Math.pow(10, numLen - 1);

            for (int i = 0; i < numLen; i++) {
                if (primeNum.toString().contains("0")) {
                    nonCircularPrimeSet.add(primeNum);
                    break;
                }

                if (primeSet.contains(primeNum)) {
                    holder.add(primeNum);
                } else {
                    isCircularPrime = false;
                }

                primeNum = primeNum % 10 * divisor + primeNum / 10; // rotate number;
            }

            // add all prime from holder set because they are not circular prime
            if (!isCircularPrime) {
                for (Integer holderNum : holder) {
                    nonCircularPrimeSet.add(holderNum);
                }
            }
        }

        System.out.println(primeSet.size() - nonCircularPrimeSet.size());
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
                primeSet.add(i);
        }
    }
}