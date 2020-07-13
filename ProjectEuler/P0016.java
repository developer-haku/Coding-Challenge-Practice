import java.math.BigInteger;
import java.util.Arrays;

public class P0016 {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        for (int i = 0; i < 1000; i++) {
            p = p.multiply(two);
        }
        System.out.println(Arrays.stream(p.toString().split("")).mapToInt(Integer::parseInt).sum());
    }
}