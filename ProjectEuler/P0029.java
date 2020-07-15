import java.util.HashSet;

public class P0029 {
    public static void main(String[] args) {
        HashSet<Double> distinctTerms = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                Double n = Math.pow(a, b);
                if (!distinctTerms.contains(n))
                    distinctTerms.add(n);
            }
        }
        System.out.println(distinctTerms.size());
    }
}