public class P0040 {

    public static void main(String[] args) {
        int p = 1; // product
        int n = 1; // d(n)
        int i = 0; // current num
        int len = 0; // concat length

        while (true) {
            i++;
            len += Math.log10(i) + 1;   // count digit of current num

            if (len == n) {
                p *= i % 10;
                n *= 10;
            } else if (len > n) {
                int k = i;
                for (int j = 0; j < len - n; j++) {
                    k /= 10;
                }
                p *= k % 10;
                n *= 10;
            }

            if (len > 1000000)
                break;
        }

        System.out.println(p);
    }
}