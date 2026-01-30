import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bufferedReader.readLine());

        System.out.println(fib(n)[0]);
    }

    private static final long MOD = 1_000_000_007;

    private static long[] fib(long n) {
        if (n == 0) return new long[]{0, 1};

        long[] half = fib(n / 2);
        long a = half[0];
        long b = half[1];

        long c = (a * ((2 * b % MOD - a + MOD) % MOD)) % MOD;
        long d = (a * a % MOD + b * b % MOD) % MOD;

        if (n % 2 == 0) {
            return new long[]{c, d};
        } else {
            return new long[]{d, (c + d) % MOD};
        }
    }
}
