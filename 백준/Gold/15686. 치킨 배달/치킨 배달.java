import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<Point> houses = new ArrayList<>();
    private static List<Point> chickens = new ArrayList<>();
    private static int[] selected;
    private static int answer = Integer.MAX_VALUE;

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(stringTokenizer.nextToken());
                if (v == 1) houses.add(new Point(i, j));
                if (v == 2) chickens.add(new Point(i, j));
            }
        }

        selected = new int[M];
        comb(0, 0);

        System.out.println(answer);
    }

    private static void comb(int idx, int cnt) {
        if (cnt == M) {
            calc();
            return;
        }
        if (idx == chickens.size()) return;

        selected[cnt] = idx;
        comb(idx + 1, cnt + 1);
        comb(idx + 1, cnt);
    }

    private static void calc() {
        int sum = 0;

        for (Point h : houses) {
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i < M; i++) {
                Point c = chickens.get(selected[i]);
                int dist = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }

        answer = Math.min(answer, sum);
    }
}
