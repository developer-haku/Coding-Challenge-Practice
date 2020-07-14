public class P0019 {
    public static void main(String[] args) {
        int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int remain = 7 - 365 % 7; // skip first year
        int sundayCount = 0;

        for (int i = 1901; i <= 2000; i++) {
            months[1] = isLeap(i) ? 29 : 28;
            for (int j = 0; j < months.length; j++) {
                if (remain == 1)
                    sundayCount++;
                remain = 7 - (months[j] - remain) % 7;
            }
        }

        System.out.println(sundayCount);
    }

    public static boolean isLeap(int i) {
        return (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
    }
}