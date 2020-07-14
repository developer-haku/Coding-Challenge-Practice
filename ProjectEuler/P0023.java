import java.util.HashSet;

public class P0023 {
    public static void main(String[] args) {
        HashSet<Integer> abdList = new HashSet<Integer>();
        int sum = 0;

        for (int i = 1; i < 28124; i++) {
            if (i < d(i))
                abdList.add(i);
        }

        for (int i = 1; i < 28124; i++) {
            boolean flag = false;
            for (Integer n : abdList) {
                if (abdList.contains(i - n)) {
                    flag = true;
                    break;
                }
            }
            sum += flag ? 0 : i;
        }

        System.out.println(sum);
    }

    public static int d(int n) {
        int sum = 0;
        for (int i = 1; i < n / 2; i++) {
            if (n % i == 0) {
                if (n / i < i)
                    break;
                sum += n / i != i ? (n / i + i) : i;

            }
        }
        return sum - n;
    }
}