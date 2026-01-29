import java.io.*;

public class Main {
    private static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        map = new char[N][2 * N - 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                map[i][j] = ' ';
            }
        }

        draw(0, N - 1, N);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stringBuilder.append(map[i]).append('\n');
        }

        System.out.print(stringBuilder);
    }

    private static void draw(int r, int c, int size) {
        if (size == 3) {
            map[r][c] = '*';

            map[r + 1][c - 1] = '*';
            map[r + 1][c + 1] = '*';

            for (int i = -2; i <= 2; i++) {
                map[r + 2][c + i] = '*';
            }
            return;
        }

        int half = size / 2;

        draw(r, c, half);
        draw(r + half, c - half, half);
        draw(r + half, c + half, half);
    }
}
