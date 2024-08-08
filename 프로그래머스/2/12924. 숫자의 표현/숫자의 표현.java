class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if (n == 1) {
            return 1;
        }
        
        int start = 1; int end = 2;
        int total = start + end;
        
        while (end < n) {
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
        
        return answer + 1;
    }
}