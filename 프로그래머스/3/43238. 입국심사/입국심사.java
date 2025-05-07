import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long max = -1;
        for (int time : times) {
            max = Math.max(max, time);
        }
        max *= n;
        
        long left = 1; long right = max;
        answer = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isRight(mid, times, n)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean isRight(long mid, int[] times, int n) {
        long sum = 0;
        for (int time : times) {
            sum += mid / time;
        }
        return sum >= n;
    }
}