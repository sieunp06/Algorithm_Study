import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> q = new LinkedList<>();
        
        for (int num: arr) {
            if (q.isEmpty()) {
                q.add(num);
                continue;
            } 
            if (q.peekLast() == num) {
                continue;
            }
            q.add(num);
        }
        
        int[] answer = new int[q.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }

        return answer;
    }
}