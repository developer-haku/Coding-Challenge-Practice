public class P0033 {
    public static void main(String[] args) {
        int numeratorProduct = 1;
        int denominatorProduct = 1;

        for (int i = 10; i < 100; i++) {
            if (i % 10 == 0)
                continue;
            for (int j = 10; j < 100; j++) {
                // skil trivial examples and value greater or equal than 1
                if (i >= j || j % 10 == 0 || (i % 11 == 0 && j % 11 == 0) || (i % 10 == j / 10 && i / 10 == j % 10))
                    continue;
                if ((double) i / j == getRemovedCommonDigitFractionValue(i, j)) {
                    numeratorProduct *= i;
                    denominatorProduct *= j;
                }
            }
        }
        System.out.println(denominatorProduct / gcd(numeratorProduct, denominatorProduct));
    }

    public static double getRemovedCommonDigitFractionValue(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        for (int i = 0; i < strA.length(); i++) {
            for (int j = 0; j < strB.length(); j++) {
                if (strA.charAt(i) == strB.charAt(j)) {
                    return Double.valueOf(strA.replaceFirst(Character.toString(strA.charAt(i)), ""))
                            / Double.valueOf(strB.replaceFirst(Character.toString(strA.charAt(i)), ""));
                }
            }
        }
        return 0;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}