import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= number; i++) {
            int num = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (i / j == j) {
                        num ++;
                    } else {
                        num += 2;   
                    }                    
                }
            }
            list.add(num);
        }
        
        for (int num : list) {
            if (num > limit) {
                answer += power;
            } else {
                answer += num;
            }
        }
        return answer;
    }
}