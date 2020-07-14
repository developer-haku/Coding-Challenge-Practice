import java.math.BigInteger;
import java.util.Arrays;

public class P0020 {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(factorial(100).toString().split("")).mapToInt(Integer::parseInt).sum());
    }

    public static BigInteger factorial(int n) {
        BigInteger p = new BigInteger("1");
        for (; n > 1; n--) {
            p = p.multiply(new BigInteger(String.valueOf(n)));
        }
        return p;
    }
}