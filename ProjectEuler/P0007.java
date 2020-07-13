import javax.imageio.ImageTypeSpecifier;

public class P0007 {
    public static void main(String[] args) {
        int i = 2, counter = 0;
        while (true) {
            if (isPrime(i)) {
                counter++;
            }
            if (counter == 10001) {
                System.out.println(i);
                break;
            }
            i++;
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