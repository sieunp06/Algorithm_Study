import java.io.*;
import java.util.*;

public class Solution {
    static int K;
    static int[][] magnets = new int[4][8];
    static int[][] rotateInfo;

    static int[] direction;
    static boolean[] visited;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            rotate();
            int score = calculateScore();
            stringBuilder.append("#").append(testCase).append(" ").append(score).append("\n");
        }
        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        K = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < 4; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 8; j++) {
                magnets[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        rotateInfo = new int[K][2];
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            rotateInfo[i][0] = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            rotateInfo[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        direction = new int[4];
        visited = new boolean[4];
    }

    static void rotate() {
        for (int i = 0; i < K; i++) {
            int magnetIdx = rotateInfo[i][0];
            int dir = rotateInfo[i][1];

            Arrays.fill(visited, false);
            Arrays.fill(direction, 0);

            spreadRotation(magnetIdx, dir);
            applyRotation();
        }
    }

    static void spreadRotation(int idx, int dir) {
        visited[idx] = true;
        direction[idx] = dir;

        if (idx > 0 && !visited[idx - 1]) {
            if (magnets[idx][6] != magnets[idx - 1][2]) {
                spreadRotation(idx - 1, -dir);
            }
        }

        if (idx < 3 && !visited[idx + 1]) {
            if (magnets[idx][2] != magnets[idx + 1][6]) {
                spreadRotation(idx + 1, -dir);
            }
        }
    }

    static void applyRotation() {
        for (int i = 0; i < 4; i++) {
            if (direction[i] == 1) rotateClockwise(i);
            else if (direction[i] == -1) rotateCounterClockwise(i);
        }
    }

    static void rotateClockwise(int idx) {
        int temp = magnets[idx][7];
        for (int i = 7; i > 0; i--) {
            magnets[idx][i] = magnets[idx][i - 1];
        }
        magnets[idx][0] = temp;
    }

    static void rotateCounterClockwise(int idx) {
        int temp = magnets[idx][0];
        for (int i = 0; i < 7; i++) {
            magnets[idx][i] = magnets[idx][i + 1];
        }
        magnets[idx][7] = temp;
    }

    static int calculateScore() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (magnets[i][0] == 1) {
                score += (1 << i);
            }
        }
        return score;
    }
}
