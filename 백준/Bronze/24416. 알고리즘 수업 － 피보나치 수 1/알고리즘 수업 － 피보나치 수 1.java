import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N;
    static int count_fibo = 0;
    static int count_fibonacci = 0;

    static int[] dp;

    public static void main(String[] args) throws IOException{
        init();
        fibo(N);
        fibonacci(N);
        System.out.print(count_fibo + " " + count_fibonacci);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        dp = new int[N + 1];
    }

    static int fibo(int num) {
        if (num == 1 || num == 2) {
            count_fibo++;
            return 1;
        }
        return fibo(num - 1) + fibo(num - 2);
    }

    static int fibonacci(int num) {
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= num; i++) {
            count_fibonacci++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[num];
    }
}
