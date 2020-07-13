
public class P0005 {

    public static void main(String[] args) {
        int i = 20;
        while (true) {
            if (check(i)) {
                System.out.println(i);
                break;
            }
            i += 20;
        }
    }

    public static boolean check(int n) {
        for (int i = 20; i > 1; i--) {
            if (n % i != 0)
                return false;
        }
        return true;
    }

}