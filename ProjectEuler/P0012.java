public class P0012 {
    public static void main(String[] args) {
        int curr = 0;
        int i = 1;
        while (true) {
            curr += i;
            if (countDivisors(curr) > 500) {
                System.out.println(curr);
                break;
            }
            i++;
        }
    }

    public static int countDivisors(int n) {
        int counter = 0;
        for (int i = 1; i < n / 2; i++) {
            if (n % i == 0) {
                counter += n / i != i ? 2 : 1;
                if (n / i < i)
                    break;
            }
        }
        return counter;
    }
}