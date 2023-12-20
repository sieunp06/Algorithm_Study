import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
        int len = (int)(right - left) + 1;
        
        for (int i = 1; i <= n; i++) {
            if (left - n > 0) {
                left -= n;
                continue;
            }
            for (int j = 1; j <= n; j++) {
                if (len == 0) {
                    return answer;
                }
                if (left > 0) {
                    left--;
                } else {
                    len--;
                    if (j < i) {
                        answer.add(i);
                    } else {
                        answer.add(j);
                    }   
                }
            }
        }
        
        return answer;
    }
}