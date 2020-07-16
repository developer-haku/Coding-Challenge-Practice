import java.util.Arrays;

public class P0034 {
    public static void main(String[] args) {
        int i = 3;
        int sum = 0;
        int count = 0; // OEIS@A014080 Only 4 factorions

        while (count != 2) {
            if (i == splitAndCal(Integer.toString(i))) {
                sum += i;
                count++;
            }
            i++;
        }
        
        System.out.println(sum);
    }

    public static int splitAndCal(String n) {
        return Arrays.stream(n.split("")).mapToInt(m -> fatorial(Integer.valueOf(m))).sum();
    }

    public static int fatorial(int n) {
        return n == 0 ? 1 : n * fatorial(n - 1);
    }
}