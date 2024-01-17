import java.util.List;
import java.util.ArrayList;

class Solution {
    List<Integer>[] computer;
    boolean[] visited;
    int answer = 0;
    public int solution(int n, int[][] computers) {
        computer = new ArrayList[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            computer[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    if (i != j) {
                        computer[i].add(j);
                        computer[j].add(i);
                    }   
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                DFS(i);
            }
        }
        
        return answer;
    }
    
    void DFS(int num) {
        if (visited[num]) {
            return;
        }
        visited[num] = true;
        for (int i : computer[num]) {
            if (!visited[i]) {
                DFS(i);   
            }
        }
    }
}