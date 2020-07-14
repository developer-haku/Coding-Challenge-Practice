import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class P0018 {
    private static ArrayList<int[]> list = new ArrayList<>();
    private static int max = 0;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("P0018.txt"));
            String line = br.readLine();
            while (line != null) {
                list.add(Arrays.stream(line.split(" ")).mapToInt(Integer::valueOf).toArray());
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scan(0, 0, 0, list.get(0)[0]);
        System.out.println(max);
    }

    // DFS
    public static void scan(int x, int y, int level, int sum) {
        if (level == list.size() - 1) {
            if (sum > max) {
                max = sum;
            }
            return;
        }

        // left
        scan(x, y + 1, level + 1, sum + list.get(y + 1)[x]);
        // right
        scan(x + 1, y + 1, level + 1, sum + list.get(y + 1)[x + 1]);
    }
}