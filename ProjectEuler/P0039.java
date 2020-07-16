public class P0039 {
    public static void main(String[] args) {
        int maxSolutions = 0;
        int numWithMaxSolutions = 0;

        for (int i = 1; i < 1001; i++) {
            int count = countSolution(i);
            if (count > maxSolutions) {
                maxSolutions = count;
                numWithMaxSolutions = i;
            }
        }
        System.out.println(numWithMaxSolutions);
    }

    public static int countSolution(int n) {
        int count = 0;
        for (int i = 1; i < Math.ceil((double) n / 2); i++) {
            for (int j = i; j < n - i; j++) {
                if (i * i + j * j == (n - i - j) * (n - i - j)) {
                    count++;
                }
            }
        }
        return count;
    }
}