import java.util.HashSet;

public class P0044 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(); // set for pentagon num
        for (int i = 1; true; i++) { // p(i) ~ p(inf)
            int pI = p(i);
            set.add(pI);
            for (int j = i - 1; j > 0; j--) { // p(i - 1) to p(1)
                int pJ = p(j);
                // p(i)-p(j) is always the current smallest possible pentagonal number
                if (set.contains(pI - pJ)) {
                    // if difference is a pentagonal nums, check the sum is pentagonal number also
                    int sum = pI + pJ;
                    for (int k = i + 1; p(k) <= sum; k++) { // start checking from p(i+1)
                        if (p(k) == sum) {
                            System.out.println(pI - pJ);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static int p(int n) {
        return n * (3 * n - 1) / 2;
    }
}