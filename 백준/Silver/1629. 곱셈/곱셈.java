import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(cal(A, B, C));
    }

    private static long cal(long a, long b, long mod) {
        if (b == 0) return 1;
        long half = cal(a, b / 2, mod);
        long result = (half * half) % mod;
        if (b % 2 == 1) {
            result = (result * (a % mod)) % mod;
        }
        return result;
    }
}
