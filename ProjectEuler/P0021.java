public class P0021 {
    public static void main(String[] args) {
        int sum = 0;
        for (int a = 0; a < 10_000; a++) {
            int b = d(a);
            int db = d(b);
            if (db == a && a != b && b < 10_000 && b > 0) {
                sum += a;
            }
        }
        System.out.println(sum);
    }

    public static int d(int n) {
        int sum = 0;
        for (int i = 1; i < n / 2; i++) {
            if (n % i == 0) {
                if (n / i < i)
                    break;
                sum += n / i != i ? (n / i + i) : i;

            }
        }
        return sum - n;
    }
}