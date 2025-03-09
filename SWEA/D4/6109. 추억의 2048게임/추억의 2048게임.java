import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static int T, N;
    private static String command;

    private static int[][] board;
    private static int[][] result;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            move(command);
            print(testCase);
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        command = stringTokenizer.nextToken();

        board = new int[N][N];
        result = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void move(String command) {
        if (command.equals("left")) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if (board[i][j] == 0) continue;

                    int k = j + 1;
                    while (k < N - 1 && board[i][k] == 0) k++;

                    if (board[i][j] == board[i][k]) {
                        board[i][j] *= 2;
                        board[i][k] = 0;
                    }
                }
                int idx = 0;
                for (int j = 0; j < N; j++) {
                    if (board[i][j] != 0) result[i][idx++] = board[i][j];
                }
            }
        } else if (command.equals("right")) {
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j > 0; j--) {
                    if (board[i][j] == 0) continue;

                    int k = j - 1;
                    while (k > 0 && board[i][k] == 0) k--;

                    if (board[i][j] == board[i][k]) {
                        board[i][j] *= 2;
                        board[i][k] = 0;
                    }
                }
                int idx = N - 1;
                for (int j = N - 1; j >= 0; j--) {
                    if (board[i][j] != 0) result[i][idx--] = board[i][j];
                }
            }
        } else if (command.equals("up")) {
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N - 1; i++) {
                    if (board[i][j] == 0) continue;

                    int k = i + 1;
                    while (k < N - 1 && board[k][j] == 0) k++;

                    if (board[i][j] == board[k][j]) {
                        board[i][j] *= 2;
                        board[k][j] = 0;
                    }
                }
                int idx = 0;
                for (int i = 0; i < N; i++) {
                    if (board[i][j] != 0) result[idx++][j] = board[i][j];
                }
            }
        } else {
            for (int j = 0; j < N; j++) {
                for (int i = N - 1; i > 0; i--) {
                    if (board[i][j] == 0) continue;

                    int k = i - 1;
                    while (k > 0 && board[k][j] == 0) k--;

                    if (board[i][j] == board[k][j]) {
                        board[i][j] *= 2;
                        board[k][j] = 0;
                    }
                }
                int idx = N - 1;
                for (int i = N - 1; i >= 0; i--) {
                    if (board[i][j] != 0) result[idx--][j] = board[i][j];
                }
            }
        }
    }

    private static void print(int testCase) {
        stringBuilder.append("#").append(testCase).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stringBuilder.append(result[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
    }
}
