public class P0017 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i =1; i <= 1000; i++) {
            sum += convertAndGetLen(i);
        }
        System.out.println(sum);
    }

    public static int convertAndGetLen(int n) {
        // [one, two, three, four, five, six, seven, eight, nine]
        int[] $1_9 = { 3, 3, 5, 4, 4, 3, 5, 5, 4 };
        // [ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen]
        int[] $10_19 = { 3, 6, 6, 8, 8, 7, 7, 9, 8, 8 };
        // [twenty, thirty, fourty, fifty, sixty, seventy, eighty, ninty]
        int[] $10s = { 6, 6, 6, 5, 5, 7, 6, 5 };
        // [hundred, thousand]
        int[] $00s = { 7, 8 };

        int len = 0;

        if (n < 10)
            len = $1_9[n - 1];
        else if (n < 20) {
            len = $10_19[n - 10];
        } else if (n < 100) {
            len = $10s[n / 10 - 2] + ((n % 10 == 0) ? 0 : $1_9[n % 10 - 1]);
        } else if (n < 1000) {
            len = $1_9[n / 100 - 1] + $00s[0];
            len += (n % 100 == 0) ? 0 : convertAndGetLen(n % 100) + 3; // 3 = and
        } else
            len = 11; // one thousand

        return len;
    }
}