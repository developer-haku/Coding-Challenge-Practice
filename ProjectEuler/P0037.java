import java.util.TreeSet;

public class P0037 {
    private static TreeSet<Integer> primeSet = new TreeSet<>();

    public static void main(String[] args) {
        int sum = 0;

        soe(1_000_000);

        for (Integer primeNum : primeSet) {
            int numLen = (int) (Math.log10(primeNum) + 1);
            if (primeNum > 7 && check(primeNum, numLen, true) && check(primeNum, numLen, false)) {
                sum += primeNum;
            }
        }
        System.out.println(sum);
    }

    public static boolean check(int n, int numLen, boolean left) {
        for (int i = 0; i < numLen - 1; i++) {
            n = left ? n % (int) Math.pow(10, numLen - i - 1) : n / 10;
            if (!primeSet.contains(n))
                return false;
        }
        return true;
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