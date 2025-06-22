import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[][] board;

    private static final Queue<Virus> viruses = new ArrayDeque<>();

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    private static int max = Integer.MIN_VALUE;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
        System.out.println(max);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void dfs(int numOfWall) {
        if (numOfWall == 3) {
            spreadVirus();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(numOfWall + 1);
                    board[i][j] = 0;
                }
            }
        }

    }

    private static void spreadVirus() {
        int[][] clonedBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                clonedBoard[i][j] = board[i][j];
                if (board[i][j] == 2) {
                    viruses.add(new Virus(i, j));
                }
            }
        }

        while (!viruses.isEmpty()) {
            Virus virus = viruses.poll();
            int r = virus.r;
            int c = virus.c;
            for (int i = 0; i < dr.length; i++) {
                if (r + dr[i] >= 0 && r + dr[i] < N && c + dc[i] >= 0 && c + dc[i] < M && clonedBoard[r + dr[i]][c + dc[i]] == 0) {
                    clonedBoard[r + dr[i]][c + dc[i]] = 2;
                    viruses.add(new Virus(r + dr[i], c + dc[i]));
                }
            }
        }
        max = Math.max(countSafeArea(clonedBoard), max);
    }

    private static int countSafeArea(int[][] clonedBoard) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (clonedBoard[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Virus {
    int r;
    int c;

    Virus(int r, int c) {
        this.r = r;
        this.c = c;
    }
}