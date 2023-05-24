import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());

        long start = 1;
        long end = K;
        long answer = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(middle / i, N);
            }
            if (cnt < K) {
                start = middle + 1;
            } else {
                answer = middle;
                end = middle - 1;
            }
        }

        System.out.println(answer);
    }
}