import java.util.Iterator;
import java.util.TreeSet;

public class P0050 {
    private static TreeSet<Integer> primeSet = new TreeSet<>();

    public static void main(String[] args) {
        int thePrime = 0, most = 0;

        // init prime set
        soe(1_000_000);

        Iterator<Integer> it = primeSet.iterator();
        while (it.hasNext()) {
            Iterator<Integer> tempIt = primeSet.tailSet(it.next()).iterator();
            int tempMost = 0;
            int tempSum = 0;
            int tempThePrime = 0;
            int itCount = 0;
            while (tempIt.hasNext()) {
                tempSum += tempIt.next();
                if (tempSum > 1_000_000)
                    break;

                itCount++;
                if (primeSet.contains(tempSum)) {
                    if (itCount > tempMost) {
                        tempMost = itCount;
                        tempThePrime = tempSum;
                    }
                }
            }
            if (tempMost > most) {
                most = tempMost;
                thePrime = tempThePrime;
            }

        }
        System.out.println(thePrime);
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

        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                primeSet.add(i);
        }
    }
}