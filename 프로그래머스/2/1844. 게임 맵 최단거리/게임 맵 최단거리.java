import java.util.*;

class Solution {
    private int answer = 0;
    private int[][] map;
    private boolean[][] visited;
    
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        map = maps;
        visited = new boolean[maps.length][maps[0].length];
        return bfs();
    }
    
    private int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            int now_r = now[0];
            int now_c = now[1];
            int len = now[2];
            
            if (now_r == map.length - 1 && now_c == map[0].length - 1) {
                return len;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = now_r + dr[i];
                int nc = now_c + dc[i];
                
                if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, len + 1});
                }
            }
        }
        return -1;
    }
    
    private boolean isIn(int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
    }
}