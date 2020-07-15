public class P0028 {
    public static void main(String[] args) {
        int sum = 1;
        int currNum = 1;
        for (int i = 2; i < 1001; i += 2) {
            for (int j = 0; j < 4; j++) {
                currNum += i;
                sum += currNum;
            }
        }
        System.out.println(sum);
    }
}