import java.math.BigInteger;

public class P0048 {
    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;

        for (int i = 1; i < 1001; i++) {
            sum = sum.add(pow(i));
        }
        System.out.println(sum.toString().substring(sum.toString().length() - 10));
    }

    public static BigInteger pow(int n) {
        BigInteger bigN = new BigInteger("" + n);
        BigInteger product = new BigInteger("" + n);
        for (int i = 0; i < n - 1; i++) {
            product = product.multiply(bigN);
        }
        return product;
    }
}