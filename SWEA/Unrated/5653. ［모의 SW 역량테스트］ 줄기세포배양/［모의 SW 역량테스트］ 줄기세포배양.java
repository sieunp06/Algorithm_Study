import java.io.*;
import java.util.*;

public class Solution {

    static int N, M, K, ex;
    static Cell [][] map;
    static boolean[][] visited;
    static Queue<Cell> q = new ArrayDeque<>();

    private static class Cell{
        int x, y, vital, beforeEnableTime, afterEnableTime;
        Cell(int x, int y, int v, int b, int a){
            this.x = x;
            this.y = y;
            this.vital = v;
            this.beforeEnableTime = b;
            this.afterEnableTime = a;
        }
    }

    static final int[] dx = {-1,0,1,0};
    static final int[] dy = {0,1,0,-1};

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(bufferedReader.readLine());
        for(int t = 1; t <= tc; t++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            M = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            ex = 300;

            map = new Cell [700][700];
            visited = new boolean[700][700];
            q.clear();

            for(int i = 0; i < N; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j = 0; j < M; j++) {
                    int vital = Integer.parseInt(stringTokenizer.nextToken());

                    if(vital == 0) continue;

                    map[i + ex][j + ex] = new Cell(i + ex, j + ex, vital, vital, 0);

                    q.offer(new Cell(i + ex, j + ex, vital, vital, 0));
                    visited[i + ex][j + ex] = true;
                }
            }
            stringBuilder.append("#").append(t).append(" ").append(bfs()).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int bfs() {
        for(int time=0; time<K; time++) {
            Map<String, Cell> tempMap = new HashMap<>();

            int size = q.size();
            for(int s = 0; s < size; s++) {
                Cell cur = q.poll();

                int x = cur.x;
                int y = cur.y;
                int vital = cur.vital;
                int beforeT = cur.beforeEnableTime;
                int afterT = cur.afterEnableTime;

                if(beforeT > 0) {
                    q.offer(new Cell(x, y, vital, beforeT - 1, afterT));
                }
                else {
                    if(afterT == 0) {
                        for(int d=0; d<4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if(visited[nx][ny]) continue;

                            String key = nx + "," + ny;

                            if(tempMap.containsKey(key)) {
                                if(tempMap.get(key).vital < vital) {
                                    tempMap.put(key, new Cell(nx, ny, vital, vital, 0));
                                }
                            } else {
                                tempMap.put(key, new Cell(nx, ny, vital, vital, 0));
                            }
                        }
                    }

                    if(afterT + 1 < vital) {
                        q.offer(new Cell(x, y, vital, beforeT, afterT + 1));
                    }
                }
            }

            for(Cell cell : tempMap.values()) {
                int nx = cell.x;
                int ny = cell.y;

                map[nx][ny] = cell;
                visited[nx][ny] = true;
                q.offer(cell);
            }
        }

        return q.size();
    }
}