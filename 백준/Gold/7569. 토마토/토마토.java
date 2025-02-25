import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][][] box;   // 높이, 세로 가로
    private static Queue<int[]> tomatoes;

    private static int M;   // 상자의 크기(가로)
    private static int N;   // 상자의 크기(세로)
    private static int H;   // 쌓아올려지는 상자의 수

    private static int answer = 0;

    // 상하좌우 위 아래
    private static int[] dr = {-1, 1, 0, 0, 0, 0};
    private static int[] dc = {0, 0, -1, 1, 0, 0};
    private static int[] dh = {0, 0, 0, 0, -1, 1};

    private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        if (check()) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());

        box = new int[H][N][M];
        tomatoes = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    if (box[i][j][k] == 1) {
                        tomatoes.add(new int[] {i, j, k, 0});
                    }
                }
            }
        }

    }

    private static void bfs() {
        while (!tomatoes.isEmpty()) {
            int[] tomato = tomatoes.poll();

            answer = Math.max(answer, tomato[3]);

            for (int i = 0; i < dr.length; i++) {
                int now_h = tomato[0] + dh[i];
                int now_r = tomato[1] + dr[i];
                int now_c = tomato[2] + dc[i];

                if (now_h < 0 || now_h >= H) {
                    continue;
                }
                if (now_r < 0 || now_r >= N) {
                    continue;
                }
                if (now_c <0 || now_c >= M) {
                    continue;
                }
                if (box[now_h][now_r][now_c] == 0) {
                    box[now_h][now_r][now_c] = 1;
                    tomatoes.add(new int[] {now_h, now_r, now_c, tomato[3] + 1});
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

