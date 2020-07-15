
public class P0027 {

    public static void main(String[] args) {
        int max = 0;
        int[] cof = { 0, 0 }; // a, b
        for (int a = -1000; a <= 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int q = quadraticCheck(a, b);
                if (q > max) {
                    max = q;
                    cof[0] = a;
                    cof[1] = b;
                }
            }
        }

        System.out.println(cof[0] * cof[1]);
    }

    public static int quadraticCheck(int a, int b) {
        int max = 0;
        int n = 0;
        while (true) {
            if (isPrime(n * n + a * n + b))
                max++;
            else
                break;
            n++;
        }
        return max;
    }

    public static boolean isPrime(long n) {
        if (n == 2 || n == 3 || n == 5)
            return true;

        if (n < 2 || n % 2 == 0 || n % 3 == 0 || n % 5 == 0)
            return false;

        for (long i = 7; i < n - 1; i += 4) {
            if (n % i == 0)
                return false;
            for (int j = 0; j < 3; j++) {
                i += 2;
                if (i >= n) {
                    break;
                }
                if (n % i == 0)
                    return false;
            }
        }

        return true;
    }
}
