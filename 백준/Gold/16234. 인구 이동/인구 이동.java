import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] countries;
    static boolean[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        L = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());

        countries = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                countries[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int days = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break;
            days++;
        }

        System.out.println(days);
    }

    static boolean bfs(int sr, int sc) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> unionList = new ArrayList<>();
        queue.offer(new int[] {sr, sc});
        unionList.add(new int[] {sr, sc});
        visited[sr][sc] = true;

        int sum = countries[sr][sc];
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (!isIn(nr, nc) || visited[nr][nc]) continue;

                int diff = Math.abs(countries[r][c] - countries[nr][nc]);
                if (diff >= L && diff <= R) {
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                    unionList.add(new int[] {nr, nc});
                    sum += countries[nr][nc];
                    count++;
                }
            }
        }

        if (count > 1) {
            int newPopulation = sum / count;
            for (int[] pos : unionList) {
                countries[pos[0]][pos[1]] = newPopulation;
            }
            return true;
        }

        return false;
    }

    static boolean isIn(int r, int c) {
        return r < N && c < N && r >= 0 && c >= 0;
    }
}