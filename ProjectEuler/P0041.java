public class P0041 {
    public static void main(String[] args) {
        int max = 0;
        int n = 1_000_000_000;

        // Sieve of Eratosthenes
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
        /************************/

        for (int i = 2; i <= n; i++)
            if (prime[i] == true)
                if (isPandigit(i))
                    max = i;

        System.out.println(max);
    }

    public static boolean isPandigit(int num) {
        int n = (int) Math.log10(num) + 1;
        String strNum = Integer.toString(num);
        for (int i = 1; i <= n; i++) {
            if (!strNum.contains(Integer.toString(i))) {
                return false;
            }
        }
        return true;
    }
}