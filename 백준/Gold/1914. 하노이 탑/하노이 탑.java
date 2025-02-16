import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        BigInteger count = new BigInteger("2");
        System.out.println(count.pow(N).subtract(new BigInteger("1")));

        if (N <= 20) {
            hanoi(1, 3, 2, N);
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
    }

    private static void hanoi(int from, int to, int tmp, int n) {
        if (n == 1) {
            System.out.println(from + " " + to);
            return;
        }
        hanoi(from, tmp, to, n - 1);
        System.out.println(from + " " + to);
        hanoi(tmp, to, from, n - 1);
    }
}
