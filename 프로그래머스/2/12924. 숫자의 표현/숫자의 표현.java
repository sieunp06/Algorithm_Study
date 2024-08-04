class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start = 1; int end = 1;
        int total = 1;
        while (end <= n) {
            if (total == n) {
                answer++;
                total -= start; 
                start++; end++;
                total += end;
            } else if (total < n) {
                end++;
                total += end;
            } else {
                total -= start;
                start++;
            }
        }
        
        return answer;
    }
}