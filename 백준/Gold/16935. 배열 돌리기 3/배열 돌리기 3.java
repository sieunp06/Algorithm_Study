import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, R;
    private static int[][] board;
    private static int[] commands;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        processCommands();
        printBoard();
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        String[] input = bufferedReader.readLine().split(" ");
        commands = new int[input.length];
        for (int i = 0; i < commands.length; i++) {
            commands[i] = Integer.parseInt(input[i]);
        }
    }

    private static void processCommands() {
        for (int command : commands) {
            switch (command) {
                case 1: verticalFlip(); break;
                case 2: horizontalFlip(); break;
                case 3: rotateRight(); break;
                case 4: rotateLeft(); break;
                case 5: moveGroupsClockwise(); break;
                case 6: moveGroupsCounterClockwise(); break;
            }
        }
    }

    private static void verticalFlip() {
        for (int i = 0; i < N / 2; i++) {
            int[] temp = board[i];
            board[i] = board[N - 1 - i];
            board[N - 1 - i] = temp;
        }
    }

    private static void horizontalFlip() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = board[i][j];
                board[i][j] = board[i][M - 1 - j];
                board[i][M - 1 - j] = temp;
            }
        }
    }

    private static void rotateRight() {
        int[][] newBoard = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newBoard[j][N - 1 - i] = board[i][j];
            }
        }
        board = newBoard;
        int temp = N;
        N = M;
        M = temp;
    }

    private static void rotateLeft() {
        int[][] newBoard = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newBoard[M - 1 - j][i] = board[i][j];
            }
        }
        board = newBoard;
        int temp = N;
        N = M;
        M = temp;
    }

    private static void moveGroupsClockwise() {
        int[][] newBoard = new int[N][M];
        int halfN = N / 2, halfM = M / 2;

        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                newBoard[i][j + halfM] = board[i][j];
                newBoard[i + halfN][j + halfM] = board[i][j + halfM];
                newBoard[i + halfN][j] = board[i + halfN][j + halfM];
                newBoard[i][j] = board[i + halfN][j];
            }
        }
        board = newBoard;
    }

    private static void moveGroupsCounterClockwise() {
        int[][] newBoard = new int[N][M];
        int halfN = N / 2, halfM = M / 2;

        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                newBoard[i + halfN][j] = board[i][j];
                newBoard[i + halfN][j + halfM] = board[i + halfN][j];
                newBoard[i][j + halfM] = board[i + halfN][j + halfM];
                newBoard[i][j] = board[i][j + halfM];
            }
        }
        board = newBoard;
    }

    private static void printBoard() {
        for (int[] row : board) {
            for (int val : row) {
                stringBuilder.append(val).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }
}
