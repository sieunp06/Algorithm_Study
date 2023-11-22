import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int num : score) {
            if (q.size() < k) {
                q.add(num);   
            } else {
                if (num > q.peek()) {
                    q.poll();
                    q.add(num);
                }
            }
            answer.add(q.peek());
        }
        return answer;
    }
}