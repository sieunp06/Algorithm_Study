import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, M, B;
    private static int[][] blocks;
    private static int minHeight = Integer.MAX_VALUE;
    private static int maxHeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());

        blocks = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                blocks[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                minHeight = Math.min(minHeight, blocks[i][j]);
                maxHeight = Math.max(maxHeight, blocks[i][j]);
            }
        }
    }

    private static void solve() {
        int answerTime = Integer.MAX_VALUE;
        int answerHeight = -1;

        for (int target = minHeight; target <= maxHeight; target++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int heightDiff = blocks[i][j] - target;

                    if (heightDiff > 0) { 
                        time += 2 * heightDiff;
                        inventory += heightDiff;
                    } else if (heightDiff < 0) { 
                        time += -heightDiff;
                        inventory += heightDiff; 
                    }
                }
            }

            if (inventory < 0) continue; 

            if (time < answerTime) {
                answerTime = time;
                answerHeight = target;
            } else if (time == answerTime && target > answerHeight) {
                answerHeight = target;
            }
        }

        stringBuilder.append(answerTime).append(" ").append(answerHeight).append("\n");
    }
}
