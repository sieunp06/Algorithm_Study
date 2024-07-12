import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new LinkedList<>();
        
        for (int num: arr) {
            if (dq.isEmpty()) {
                dq.add(num);
                continue;
            }
            if (dq.peekLast() != num) {
                dq.add(num);
            }
        }
        
        int[] answer = new int[dq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dq.pollFirst();
        }

        return answer;
    }
}