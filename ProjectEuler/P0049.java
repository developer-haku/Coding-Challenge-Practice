import java.util.ArrayList;
import java.util.Arrays;

public class P0049 {
    private static ArrayList<Integer> p = new ArrayList<>();

    public static void main(String[] args) {
        // init
        soe(9999);

        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) > 3333)
                break;
            for (int j = i + 1; j < p.size(); j++) {
                if (p.get(j) > 6666)
                    break;
                int diff = p.get(j) - p.get(i);
                if (p.contains(p.get(j)) && p.contains(p.get(j) + diff)) {
                    if (permuteCheck(p.get(i).toString(), p.get(j).toString(), Integer.toString(p.get(j) + diff)))
                        System.out.println("" + p.get(i) + p.get(j) + (p.get(j) + diff));
                }
            }
        }
    }

    public static boolean permuteCheck(String... nums) {
        char[][] numsChars = { nums[0].toCharArray(), nums[1].toCharArray(), nums[2].toCharArray() };
        for (char[] c : numsChars)
            Arrays.sort(c);

        for (int i = 0; i < 4; i++)
            if (numsChars[0][i] != numsChars[1][i] || numsChars[1][i] != numsChars[2][i])
                return false;

        return true;
    }

    // Sieve of Eratosthenes
    public static void soe(int n) {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        for (int i = 1000; i <= n; i++) {
            if (prime[i] == true)
                p.add(i);
        }
    }
}