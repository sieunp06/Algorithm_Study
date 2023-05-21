import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public Deque<Integer> solution(int[] numbers, String direction) {
        Deque<Integer> answer = new ArrayDeque<>();
        
        for (int num : numbers) 
            answer.offer(num);
        
        if (direction.equals("right")) {
            answer.offerFirst(answer.pollLast());
        } else {
            answer.offerLast(answer.pollFirst());
        }
        
        return answer;
    }
}