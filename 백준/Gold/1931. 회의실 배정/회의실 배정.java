import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N;
    static int[][] meetings;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            meetings[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            meetings[i][1] = Integer.parseInt(stringTokenizer.nextToken()); 
        }
    }

    static void solve() {
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int count = 0;
        int lastEndTime = 0;

        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= lastEndTime) {
                lastEndTime = meetings[i][1];
                count++;
            }
        }

        stringBuilder.append(count).append("\n");
        System.out.print(stringBuilder);
    }
}
