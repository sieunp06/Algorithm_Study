import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        // 4 
        int answer = d.length;
        
        Arrays.sort(d);
        
        int startIdx = 0;
        int endIdx = d.length - 1;
        
        int total = 0;
        
        for (int i = startIdx; i <= endIdx; i++) {
            total += d[i];
        }
        
        while (startIdx <= endIdx) {
            if (total <= budget) 
                return answer;
            else if (total > budget) {
                total -= d[endIdx];
                endIdx--;
                answer--;
            }
        }
        
        return answer;
    }
}