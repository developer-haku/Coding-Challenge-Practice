import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0024 {
    public static void main(String[] args) {
        List<String> nums = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        System.out.println(getNthLex(nums, 1_000_000));
    }

    public static String getNthLex(List<String> l, int remain) {
        List<String> list = new ArrayList<>(l);
        String result = "";
        for (int i = list.size() - 1; i > 0; i--) {
            int pick;
            if (remain == 0) {
                pick = list.size() - 1;
            } else {
                int f = factorial(i);
                pick = remain / f + (remain % f != 0 ? 1 : 0) - 1;
                remain %= f;
            }
            result += list.get(pick);
            list.remove(pick);
        }
        result += list.get(0);
        return result;
    }

    public static int factorial(int n) {
        int p = 1;
        for (; n > 1; n--) {
            p *= n;
        }
        return p;
    }
}