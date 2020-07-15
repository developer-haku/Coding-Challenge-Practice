import java.math.BigInteger;
import java.util.Arrays;

public class P0030 {
    public static void main(String[] args) {
        int sum = 0;
        int n = 5;

        // OEIS @ A252648, A052464
        // number wont exceed 10 ^ (n + 1) or n + 2 digits
        for (int i = 2; i < Math.pow(10, n + 1); i++) {
            if (String.valueOf(i)
                    .equals(Arrays.stream(String.valueOf(i).split("")).map(digit -> new BigInteger(digit).pow(n))
                            .reduce(new BigInteger("0"), BigInteger::add).toString())) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}