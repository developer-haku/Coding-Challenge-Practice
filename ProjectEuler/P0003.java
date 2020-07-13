public class P0003 {
    public static void main(String[] args) {
        long num = 600_851_475_143l;
        long i = 2;
        for (; i < num / 2; i++) {
            if (num % i == 0) {
                break;
            }
        }
        long largest = num / i + 1;
        for (; i < largest; i++) {
            if (num % i == 0) {
                if (isPrime(num / i)) {
                    System.out.println(num / i);
                    break;
                }
            }
        }
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