public class P0014 {
    public static void main(String[] args) {
        int longest = 0;
        long startNum = 0;
        for (long i = 1; i < 1_000_000; i++) {
            int currLen = collatz(i);
            if (currLen > longest) {
                longest = currLen;
                startNum = i;
            }
        }
        System.out.println(startNum);
    }

    public static int collatz(long num) {
        if (num < 1)
            return 0;
        int len = 1;
        while (true) {
            len++;
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = 3 * num + 1;
            }
            if (num == 1)
                break;
        }
        return len;
    }
}