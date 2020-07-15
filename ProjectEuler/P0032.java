import java.util.ArrayList;
import java.util.HashSet;

public class P0032 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> products = new HashSet<>();
        // Filter numbers with no duplicated digits
        for (int i = 1; i < 100000; i++) {
            String strNum = Integer.toString(i);
            if (strNum.contains("0"))
                continue;
            if (!hasDup(strNum))
                list.add(i);
        }

        OUTER: for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    if (!hasDup(list.get(i).toString() + list.get(j).toString())) {
                        int result = list.get(i) * list.get(j);
                        if (Integer.toString(result).contains("0"))
                            continue;
                        String str = list.get(i).toString() + list.get(j).toString() + Integer.toString(result);
                        if (str.length() == 9) {
                            if (!hasDup(str)) {
                                if (list.get(j) < list.get(i))
                                    break OUTER;
                                products.add(result);
                                // System.out.println(list.get(i) + " * " + list.get(j) + " = " + result);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(products.stream().reduce(0, Integer::sum));
    }

    public static boolean hasDup(String num) {
        HashSet<String> set = new HashSet<>();
        for (String s : num.split("")) {
            if (!set.add(s))
                return true;
        }
        return false;
    }
}