public class P0004 {
    public static void main(String[] args) {
        for (int i = 997_799; i > 100_00; i--) {
            if (isPalidrome(i))
                if (isTwo3Digits(i)) {
                    System.out.println(i);
                    break;
                }
        }
    }

    public static boolean isTwo3Digits(int n) {
        for (int i = 999; i > 99; i--) {
            if (n % i == 0)
                if (n / i > 99 && n / i < 1000)
                    return true;
        }
        return false;
    }

    public static boolean isPalidrome(int n) {
        String str = Integer.toString(n);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
}