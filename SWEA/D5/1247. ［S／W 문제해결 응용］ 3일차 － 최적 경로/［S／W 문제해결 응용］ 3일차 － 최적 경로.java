import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static int T, N;

    private static Point home;
    private static Point office;
    private static Point[] points;
    private static boolean[] visited;

    private static int answer;

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getInstance(Point p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            dfs(0, office, 0);
            stringBuilder.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        points = new Point[N];
        visited = new boolean[N];
        answer = Integer.MAX_VALUE;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        office = new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        home = new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));

        for (int i = 0; i < N; i++) {
            points[i] = new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }
    }

    private static void dfs(int count, Point pre, int total) {
        if (count == N) {
            total += home.getInstance(pre);
            answer = Math.min(answer, total);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(count + 1, points[i], total + points[i].getInstance(pre));
            visited[i] = false;
        }
    }
}