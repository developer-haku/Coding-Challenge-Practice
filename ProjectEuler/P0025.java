import java.math.BigInteger;

public class P0025 {
    public static void main(String[] args) {
        BigInteger[] holder = { new BigInteger("1"), new BigInteger("2") };
        int index = 3;
        while (true) {
            if (holder[1].toString().length() == 1000) {
                System.out.println(index);
                break;
            }
            BigInteger next = holder[0].add(holder[1]);
            holder[0] = holder[1];
            holder[1] = next;
            index++;
        }
    }
}