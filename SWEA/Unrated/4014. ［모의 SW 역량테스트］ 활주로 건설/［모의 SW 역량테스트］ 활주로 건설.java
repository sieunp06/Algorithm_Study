import java.io.*;
import java.util.*;

public class Solution {
    static int N, X;
    static int[][] map;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            X = Integer.parseInt(stringTokenizer.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                if (checkLine(map[i])) result++;
                if (checkLine(getColumn(i))) result++;
            }

            stringBuilder.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        System.out.print(stringBuilder);
    }

    static int[] getColumn(int col) {
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = map[i][col];
        }
        return result;
    }

    static boolean checkLine(int[] line) {
        boolean[] used = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int curr = line[i];
            int next = line[i + 1];
            int diff = curr - next;

            if (diff == 0) continue;

            if (diff == 1) { // 내리막
                for (int j = 1; j <= X; j++) {
                    int idx = i + j;
                    if (idx >= N || line[idx] != next || used[idx]) return false;
                }
                for (int j = 1; j <= X; j++) used[i + j] = true;
            } else if (diff == -1) {
                for (int j = 0; j < X; j++) {
                    int idx = i - j;
                    if (idx < 0 || line[idx] != curr || used[idx]) return false;
                }
                for (int j = 0; j < X; j++) used[i - j] = true;
            } else {
                return false;
            }
        }

        return true;
    }
}
