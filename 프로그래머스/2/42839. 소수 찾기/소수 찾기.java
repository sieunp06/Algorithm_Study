import java.util.List;
import java.util.ArrayList;

class Solution {
    int answer = 0;
    char[] alphabet;
    boolean[] visited;
    List<Integer> numList = new ArrayList<>();
    
    public int solution(String numbers) {
        alphabet = numbers.toCharArray();
        
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == '0') {
                continue;
            }
            
            visited = new boolean[alphabet.length];
            visited[i] = true;
            
            String start = "" + alphabet[i];
            DFS(0, start);
        }
        
        return answer;
    }
    
    void DFS(int depth, String number) {
        if (depth == alphabet.length) {
            return;
        }
        
        int targetNum = Integer.parseInt(number);
        if (isPrime(targetNum)) {
            if (!numList.contains(targetNum)) {
                answer++;
                numList.add(targetNum);
            }
        }
        
        for (int i = 0; i < alphabet.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            
            String nextNum = number + alphabet[i];
            
            DFS(depth + 1, nextNum);
            
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}