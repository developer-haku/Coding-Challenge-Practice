public class P0006 {
    public static void main(String[] args) {
        System.out.println(squareOfSum(100) - sumOfSquare(100));
    }

    public static int sumOfSquare(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    public static int squareOfSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum * sum;
    }
}