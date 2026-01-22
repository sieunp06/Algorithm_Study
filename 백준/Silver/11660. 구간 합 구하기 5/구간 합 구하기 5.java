import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[][] numbers = new int[N][N + 1];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                numbers[i][j] = Integer.parseInt(stringTokenizer.nextToken()) + numbers[i][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int total = 0;

            int x1 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int y1 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int x2 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            for (int j = x1; j <= x2; j++) {
                total += (numbers[j][y2] - numbers[j][y1]);
            }
            stringBuilder.append(total).append('\n');
        }
        System.out.println(stringBuilder);
    }
}
