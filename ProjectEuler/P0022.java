import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class P0022 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("P0022.txt"));
            Arrays.stream(br.readLine().split(",")).forEach(name -> list.add(name.substring(1, name.length() - 1)));
            list.sort(String::compareTo);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            int score = 0;
            for (int j = 0; j < list.get(i).length(); j++) {
                score += list.get(i).charAt(j) - 'A' + 1;
            }
            sum += score * (i + 1);
        }

        System.out.println(sum);
    }
}