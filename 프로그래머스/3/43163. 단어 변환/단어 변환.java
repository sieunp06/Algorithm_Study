class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return 0;
        }

        DFS(begin, target, words, 0);
        
        return answer;
    }
    
    void DFS(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            int k = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }
            
            if (k == begin.length() - 1) {
                visited[i] = true;
                DFS(words[i], target, words, cnt + 1);
                visited[i] = false;   
            }
        }
    }
}