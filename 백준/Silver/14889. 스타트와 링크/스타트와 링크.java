import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N;
    static int[][] board;
    static boolean[] visited;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        init();
        combination(0, 0);
        System.out.println(answer);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        board = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    static void combination(int depth, int start) {
        if (depth == N / 2) {
            calScore();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static void calScore() {
        int score1 = 0;
        int score2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    score1 += board[i][j] + board[j][i];
                } else if (!visited[i] && !visited[j]) {
                    score2 += board[i][j] + board[j][i];
                }
            }
        }

        answer = Math.min(answer, Math.abs(score1 - score2));
    }

}
