import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public Queue<Integer> solution(int[] num_list, int n) {
        Queue<Integer> answer = new LinkedList<>();
        
        for (int num : num_list)
            answer.offer(num);
        
        for (int i = 0; i < n; i++) {
            answer.offer(answer.poll());
        }
        
        return answer;
    }
}