import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, R;
    private static int[][] numbers;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        rotate();
        print();
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                numbers[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void rotate() {
        int border = Math.min(N, M) / 2;

        for (int i = 0; i < border; i++) {
            List<Integer> list = new ArrayList<>();

            int r1 = i;
            int r2 = N - 1 - i;
            int c1 = i;
            int c2 = M - 1 - i;
            
            for (int j = c1; j <= c2; j++) list.add(numbers[r1][j]);
            for (int j = r1 + 1; j <= r2; j++) list.add(numbers[j][c2]);
            for (int j = c2 - 1; j >= c1; j--) list.add(numbers[r2][j]);
            for (int j = r2 - 1; j > r1; j--) list.add(numbers[j][c1]);

            int len = list.size();
            if (len > 0) {
                int shift = R % len;
                Collections.rotate(list, -shift);
                
                int idx = 0;
                for (int j = c1; j <= c2; j++) numbers[r1][j] = list.get(idx++);
                for (int j = r1 + 1; j <= r2; j++) numbers[j][c2] = list.get(idx++);
                for (int j = c2 - 1; j >= c1; j--) numbers[r2][j] = list.get(idx++);
                for (int j = r2 - 1; j > r1; j--) numbers[j][c1] = list.get(idx++);
            }
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                stringBuilder.append(numbers[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }
}
