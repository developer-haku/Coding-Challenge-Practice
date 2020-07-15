import java.lang.annotation.Target;
import java.util.Arrays;

public class P0031 {
    private static int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };

    public static void main(String[] args) {
        int target = 200;

        // implementation of https://www.youtube.com/watch?v=DJ4a7cmjZY0
        int[] prev = new int[target];
        for (int i = 0; i < coins.length; i++) {
            int[] curr = new int[target];
            for (int j = 1; j <= target; j++) {
                curr[j - 1] = prev[j - 1];
                if (j >= coins[i]) {
                    int p = j - coins[i];
                    if (p == 0)
                        curr[j - 1]++;
                    else
                        curr[j - 1] += curr[p - 1];
                }
            }
            prev = curr;
        }
        //**************************************************************/

        System.out.println(prev[prev.length - 1]);
    }
}