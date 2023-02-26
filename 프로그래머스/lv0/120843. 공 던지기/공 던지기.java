import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i <numbers.length; i++)
            q.offer(numbers[i]);
        
        int count = 0;
        
        while (count <= k) {
            count++;
            if (count == k) {
                answer = q.peek();
                break;
            }
            q.offer(q.poll());
            q.offer(q.poll());
        }
        
        return answer;
    }
}