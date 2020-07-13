import java.math.BigInteger;

public class P0015 {
    public static void main(String[] args) {
        int s = 20;
        BigInteger n = factorial(s * 2);
        BigInteger k = factorial(s);
        System.out.println((n.divide(k.multiply(k))));
    }

    public static BigInteger factorial(int n) {
        BigInteger p = new BigInteger("1");
        for (; n > 1; n--) {
            p = p.multiply(new BigInteger(String.valueOf(n)));
        }
        return p;
    }
}