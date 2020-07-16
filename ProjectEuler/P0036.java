public class P0036 {
    public static void main(String[] args) {
        int sum = 0;
        for (Integer i = 0; i < 1_000_000; i++) {
            if (isPalindromic(i.toString())) {
                String binary = Integer.toBinaryString(i);
                if (binary.charAt(0) != '0') {
                    if (isPalindromic(binary)) {
                        sum += i;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean isPalindromic(String n) {
        return n.equals(new StringBuilder(n).reverse().toString());
    }
}