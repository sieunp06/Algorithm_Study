import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[][] ways;
    boolean[][] visited;
    int N; int M;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        ways = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ways[i][j] = maps[i][j];
            }
        }
        
        BFS(0, 0);
        
        if (ways[N - 1][M - 1] > 1) {
            return ways[N - 1][M - 1];
        }
        return -1;
    }
    
    void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (ways[x][y] != 0 && !visited[x][y]) {
                        ways[x][y] = ways[now[0]][now[1]] + 1;
                        visited[x][y] = true;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}