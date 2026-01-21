import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] board;
    private static Ball[] balls;
    private static Queue<State> states;
    private static boolean[][][][] visited;

    private static class Ball {
        int r, c;
        Ball(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static class State {
        Ball red, blue;
        int move;
        State(Ball red, Ball blue, int move) {
            this.red = red;
            this.blue = blue;
            this.move = move;
        }
    }

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        board = new int[N][M];
        balls = new Ball[2];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);

                if (board[i][j] == 'R') {
                    balls[0] = new Ball(i, j);
                    board[i][j] = '.';
                }
                if (board[i][j] == 'B') {
                    balls[1] = new Ball(i, j);
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(balls[0], balls[1]));
    }

    private static int bfs(Ball red, Ball blue) {
        states = new ArrayDeque<>();
        states.add(new State(red, blue, 0));
        visited[red.r][red.c][blue.r][blue.c] = true;

        while (!states.isEmpty()) {
            State state = states.poll();

            if (state.move == 10) continue;

            for (int i = 0; i < 4; i++) {
                int rr = state.red.r;
                int rc = state.red.c;
                int br = state.blue.r;
                int bc = state.blue.c;
                boolean redHole = false;
                boolean blueHole = false;

                while (board[rr + dr[i]][rc + dc[i]] != '#' && board[rr][rc] != 'O') {
                    rr += dr[i];
                    rc += dc[i];

                    if (board[rr][rc] == 'O') {
                        redHole = true;
                        break;
                    }
                }

                while (board[br + dr[i]][bc + dc[i]] != '#' && board[br][bc] != 'O') {
                    br += dr[i];
                    bc += dc[i];

                    if (board[br][bc] == 'O') {
                        blueHole = true;
                        break;
                    }
                }

                if (blueHole) continue;
                if (redHole) return state.move + 1;

                if (rr == br && rc == bc) {
                    int redDist = Math.abs(rr - state.red.r) + Math.abs(rc - state.red.c);
                    int blueDist = Math.abs(br - state.blue.r) + Math.abs(bc - state.blue.c);
                    if (redDist > blueDist) {
                        rr -= dr[i];
                        rc -= dc[i];
                    } else {
                        br -= dr[i];
                        bc -= dc[i];
                    }
                }

                if (!visited[rr][rc][br][bc]) {
                    visited[rr][rc][br][bc] = true;
                    states.add(new State(new Ball(rr, rc), new Ball(br, bc), state.move + 1));
                }
            }
        }
        return -1;
    }
}
