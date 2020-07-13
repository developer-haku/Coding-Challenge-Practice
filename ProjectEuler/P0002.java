public class P0002 {
    public static void main(String[] args) {
        int total = 2;
        int[] f = {1, 2}; // holder

        int temp;
        while(f[1] < 4_000_000) {
            temp =  f[0] + f[1];
            f[0] = f[1];
            f[1] = temp;
            total += (temp % 2 == 0) ? temp : 0;
        }
        
        System.out.println(total);
    }

    public static void s1() {
        int total = 0;
        int i = 2; // start at the third fibonacci number basic on the fib(n) method below
        int n; // current fibonacci number
        while ((n = fib(i)) <= 4_000_000) {
            total += (n % 2 == 0) ? n : 0;
            i++;
        }
        System.out.println(total);
    }

    public static int fib(int n) {
        return (n == 0 || n == 1) ? n : fib(n - 1) + fib(n - 2);
    }
}