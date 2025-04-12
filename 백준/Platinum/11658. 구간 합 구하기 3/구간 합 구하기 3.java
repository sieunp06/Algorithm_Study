import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] numbers;
    static int[][] tree;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int w = Integer.parseInt(stringTokenizer.nextToken());

            if (w == 0) {   // (x, y)를 c로 바꾸는 연산
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                int c = Integer.parseInt(stringTokenizer.nextToken());

                update(1, 1, N, x, y, c);
            } else {    // (x1, y1)부터 (x2, y2)의 합을 구해 출력하는 연산
                int x1 = Integer.parseInt(stringTokenizer.nextToken());
                int y1 = Integer.parseInt(stringTokenizer.nextToken());
                int x2 = Integer.parseInt(stringTokenizer.nextToken());
                int y2 = Integer.parseInt(stringTokenizer.nextToken());

                stringBuilder.append(sum(1, 1, N, x1, x2, y1, y2)).append("\n");
            }
        }

        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N + 1][N + 1];
        tree = new int[N * 4][N * 4]; // 2D 세그먼트 트리

        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                numbers[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                update(1, 1, N, i, j, numbers[i][j]);
            }
        }
    }

    static void update(int nodeX, int startX, int endX, int x, int y, int num) {
        if (x < startX || x > endX) return;
        if (startX == endX) {
            updateY(nodeX, 1, N, 1, x, y, num, startX, endX);
            return;
        }

        int midX = (startX + endX) / 2;
        update(nodeX * 2, startX, midX, x, y, num);
        update(nodeX * 2 + 1, midX + 1, endX, x, y, num);
        updateY(nodeX, 1, N, 1, x, y, num, startX, endX);
    }

    static void updateY(int nodeX, int startY, int endY, int nodeY, int x, int y, int num, int startX, int endX) {
        if (y < startY || y > endY) return;
        if (startY == endY) {
            if (startX == endX) {
                tree[nodeX][nodeY] = num;
            } else {
                tree[nodeX][nodeY] = tree[nodeX * 2][nodeY] + tree[nodeX * 2 + 1][nodeY];
            }
            return;
        }

        int midY = (startY + endY) / 2;
        updateY(nodeX, startY, midY, nodeY * 2, x, y, num, startX, endX);
        updateY(nodeX, midY + 1, endY, nodeY * 2 + 1, x, y, num, startX, endX);
        tree[nodeX][nodeY] = tree[nodeX][nodeY * 2] + tree[nodeX][nodeY * 2 + 1];
    }

    static int sum(int nodeX, int startX, int endX, int x1, int x2, int y1, int y2) {
        if (endX < x1 || startX > x2) return 0;
        if (x1 <= startX && endX <= x2) {
            return sumY(nodeX, 1, 1, N, y1, y2);
        }

        int midX = (startX + endX) / 2;
        return sum(nodeX * 2, startX, midX, x1, x2, y1, y2)
                + sum(nodeX * 2 + 1, midX + 1, endX, x1, x2, y1, y2);
    }

    static int sumY(int nodeX, int nodeY, int startY, int endY, int y1, int y2) {
        if (endY < y1 || startY > y2) return 0;
        if (y1 <= startY && endY <= y2) {
            return tree[nodeX][nodeY];
        }
        int midY = (startY + endY) / 2;
        return sumY(nodeX, nodeY * 2, startY, midY, y1, y2)
                +sumY(nodeX, nodeY * 2 + 1, midY + 1, endY, y1, y2);
    }
}
