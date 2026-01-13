import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bufferedReader.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        TreeMap<Long, Integer> times = new TreeMap<>();
        for (int i = 0; i < C; i++) {
            Long t = Long.parseLong(bufferedReader.readLine());
            times.put(t, times.getOrDefault(t, 0) + 1);
        }

        long[][] cows = new long[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            cows[i][0] = Long.parseLong(st.nextToken());
            cows[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(cows, (a, b) -> {
            if (a[1] == b[1]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int answer = 0;
        for (int i = 0; i < N; i++) {
            long start = cows[i][0];
            long end = cows[i][1];

            Long time = times.ceilingKey(start);
            if (time != null && time <= end) {
                int cnt = times.get(time);
                if (cnt == 1) times.remove(time);
                else times.put(time, cnt - 1);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
