import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] space;
    static int[] baby_shark;
    static Queue<Fish> fishes;

    static class Fish  {
        int r, c, dist;
        Fish(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        N = Integer.parseInt(bufferedReader.readLine());
        space = new int[N][N];
        baby_shark = new int[3];
        fishes = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (space[i][j] == 9) {
                    baby_shark[0] = i;
                    baby_shark[1] = j;
                    baby_shark[2] = 2;
                    space[i][j] = 0;
                }
            }
        }

        int time = 0;
        int eat = 0;

        while (true) {
            Fish target = findWay(baby_shark[0], baby_shark[1], baby_shark[2]);

            if (target == null) break;

            time += target.dist;
            baby_shark[0] = target.r;
            baby_shark[1] = target.c;

            space[target.r][target.c] = 0;
            eat++;

            if (baby_shark[2] == eat) {
                baby_shark[2]++;
                eat = 0;
            }
        }

        System.out.println(time);
    }

    static Fish findWay(int shark_r, int shark_c, int size) {
        boolean[][] visited = new boolean[N][N];
        int[][] dist = new int[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {shark_r, shark_c});
        visited[shark_r][shark_c] = true;

        int minDist = Integer.MAX_VALUE;
        int tr = -1, tc = -1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            if (dist[r][c] > minDist) break;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!isIn(nr, nc) || visited[nr][nc]) continue;
                if (space[nr][nc] > size) continue;

                visited[nr][nc] = true;
                dist[nr][nc] = dist[r][c] + 1;
                queue.add(new int[] {nr, nc});

                if (space[nr][nc] != 0 && space[nr][nc] < size) {
                    if (dist[nr][nc] < minDist) {
                        minDist = dist[nr][nc];
                        tr = nr;
                        tc = nc;
                    } else if (dist[nr][nc] == minDist) {
                        if (nr < tr || (nr == tr && nc < tc)) {
                            tr = nr;
                            tc = nc;
                        }
                    }
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? null : new Fish(tr, tc, minDist);
    }

    static boolean isIn(int r, int c) {
        return r < N && c < N && r >= 0 && c >= 0;
    }
}