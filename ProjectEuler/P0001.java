public class P0001 {
    public static void main(String[] args) {
        int total = 0;
        for (int i = 3; i < 1000; i++) {
            total += (i % 3 == 0 || i % 5 == 0) ? i : 0;
        }
        System.out.println(total);
    }
}