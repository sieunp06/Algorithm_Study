import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        long answer = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());

            long inverseN = modPow(N, MOD - 2);
            long value = (S % MOD) * inverseN % MOD;

            answer = (answer + value) % MOD;
        }

        System.out.println(answer);
    }

    static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }

        return result;
    }
}
