import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int answer = 0;
        int total = 0;
        
        for (int num: d) {
            total += num;
            if (total > budget) {
                break;
            }
            answer++;
        }
        return answer;
    }
}