import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());

        int[][] pools = new int[N][2];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            pools[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            pools[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(pools, Comparator.comparingInt(a -> a[0]));

        int current = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int start = pools[i][0];
            int end = pools[i][1];

            if (current >= end) continue;

            if (current < start) {
                current = start;
            }

            int need = end - current;
            int cnt = (need + L - 1) / L;

            answer += cnt;
            current += cnt * L;
        }

        System.out.println(answer);
    }
}
