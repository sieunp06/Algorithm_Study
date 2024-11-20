import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] numbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = i + numbers[i - 1];
        }
        
        int start = 1; int end = 1;
        
        while (end < n + 1) {
            int target = numbers[end] - numbers[start - 1];
            if (target == n) {
                answer++;
                start++; end++;
            } else if (target > n) {
                start++;
            } else {
                end++;
            }
        }
        
        return answer;
    }
}