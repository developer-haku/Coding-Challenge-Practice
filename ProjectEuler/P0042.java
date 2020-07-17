import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class P0042 {
    public static void main(String[] args) {
        ArrayList<String> dataList = new ArrayList<>();
        ArrayList<Integer> triNumList = new ArrayList<>();
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("P0042.txt"));
            Arrays.stream(br.readLine().split(",")).forEach(name -> dataList.add(name.substring(1, name.length() - 1)));
            dataList.sort(String::compareTo);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int longestStr = dataList.stream().max((a, b) -> a.length() - b.length()).get().length();
        for (int n = 1; true; n++) {
            int t = (int) (0.5 * n * (n + 1));
            if (t > longestStr * 26)
                break;
            else
                triNumList.add(t);
        }

        for (String s : dataList) {
            if (triNumList.contains(convert(s)))
                count++;
        }

        System.out.println(count);
    }

    public static int convert(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) - 'A' + 1);
        }
        return sum;
    }

}