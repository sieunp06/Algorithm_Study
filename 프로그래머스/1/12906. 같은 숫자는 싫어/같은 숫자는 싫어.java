import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> queue = new LinkedList<>();
        
        for (int num : arr) {
            if (queue.isEmpty()) {
                queue.add(num);
                continue;
            }
            if (queue.peekLast() != num) {
                queue.add(num);
            }
        }
        
        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}