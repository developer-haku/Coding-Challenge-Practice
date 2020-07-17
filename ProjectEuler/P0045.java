public class P0045 {
    public static void main(String[] args) {
        for (long i = 286; true; i++) {
            long tI = t(i);
            for (long j = i - 1; j > 1; j--) {
                long pJ = p(j);
                if (pJ == tI) {
                    for (long k = j - 1; k > 1; k--) {
                        if (h(k) == pJ) {
                            System.out.println(tI);
                            return;
                        }
                    }
                }

            }
        }
    }

    public static long t(long n) {
        return n * (n + 1) / 2;
    }

    public static long p(long n) {
        return n * (3 * n - 1) / 2;
    }

    public static long h(long n) {
        return n * (2 * n - 1);
    }
}