import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] coins = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int total = 0;
        for (int coin : coins) {
            total += K / coin;
            K %= coin;
        }

        System.out.println(total);
    }
}
