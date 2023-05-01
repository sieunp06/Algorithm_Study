import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        
        for (int num: arr) {
            if (num % divisor == 0)
                answer.add(num);
        }
        if (answer.isEmpty()) 
            answer.add(-1);
        else 
            Collections.sort(answer);
        
        return answer;
    }
}