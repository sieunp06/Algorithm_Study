import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int M;
    private static int N;
    private static int K;

    private static boolean[][] board;
    private static List<Integer> list;

    private static int numOfArea = 0;

    // 상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        check();
        Collections.sort(list);
        System.out.println(numOfArea);
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    private static void check() {
        list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!board[i][j]) {
                    numOfArea++;
                    list.add(dfs(i, j));
                }
            }
        }
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        M = Integer.parseInt(stringTokenizer.nextToken());  // 세로
        N = Integer.parseInt(stringTokenizer.nextToken());  // 가로
        K = Integer.parseInt(stringTokenizer.nextToken());

        board = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Math.abs(Integer.parseInt(stringTokenizer.nextToken()) - M);
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Math.abs(Integer.parseInt(stringTokenizer.nextToken()) - M);

            for (int j = y2; j < y1; j++) {
                for (int k = x1; k < x2; k++) {
                    board[j][k] = true;
                }
            }
        }
    }

    private static int dfs(int r, int c) {
        int area = 1;
        board[r][c] = true;

        for (int i = 0; i < dr.length; i++) {
            int now_r = r + dr[i];
            int now_c = c + dc[i];

            if (now_r < 0 || now_r >= M) {
                continue;
            }
            if (now_c < 0 || now_c >= N) {
                continue;
            }
            if (board[now_r][now_c]) {
                continue;
            }
            area += dfs(now_r, now_c);
        }
        return area;
    }
}
