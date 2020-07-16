import java.util.HashSet;

public class P0038 {
    public static void main(String[] args) {
        String largest = "";
        for (int i = 1; i < 10000; i++)
            for (int j = 1; j * i < 987654321 / ((j + 1) / 2); j++)
                if (check(i, j))
                    largest = concat(i, j);
        System.out.println(largest);
    }

    public static String concat(int num, int multiple) {
        String s = "";
        for (int i = 1; i < multiple + 1; i++)
            s += Integer.toString(num * i);
        return s;
    }

    public static boolean check(int num, int multiple) {
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i < multiple + 1; i++) {
            String p = Integer.toString(num * i);
            if (p.contains("0"))
                return false;
            String[] digits = p.split("");
            for (String d : digits) {
                if (!set.add(d))
                    return false;
                if (set.size() > 9)
                    return false;
            }
        }
        return set.size() == 9 ? true : false;
    }
}