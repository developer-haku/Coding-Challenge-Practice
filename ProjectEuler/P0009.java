public class P0009 {
    public static void main(String[] args) {
        for (int i = 1; i < 999; i++) {
            int left = 1000 - i;
            for (int j = 1; j < left; j++) {
                if (Math.pow(i, 2) + Math.pow(j, 2) == Math.pow((left - j), 2)) {
                    System.out.println(i * j * (left - j));
                    return;
                }
            }
        }
    }
}