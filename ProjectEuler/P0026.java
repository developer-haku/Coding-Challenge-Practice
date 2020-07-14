import java.util.ArrayList;

public class P0026 {
    public static void main(String[] args) {
        int maxCycleLen = 0;
        int maxCycleNum = 0;

        for (int i = 2; i < 1000; i++) {
            int currLen = getCycleLen(i);
            if (currLen > maxCycleLen) {
                maxCycleLen = currLen;
                maxCycleNum = i;
            }
        }

        System.out.println("[NUM]" + maxCycleNum + ": [LEN]" + maxCycleLen);
    }

    public static int getCycleLen(int n) {
        int remainder = 1;
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            if (remainder == 0) {
                return 0;
            } else {
                remainder = (remainder * 10) % n;
                if (list.contains(remainder)) {
                    break;
                }
                list.add(remainder);
            }
        }

        return list.size() - list.indexOf(remainder);
    }
}