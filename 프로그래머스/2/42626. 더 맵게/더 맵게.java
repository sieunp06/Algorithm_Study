import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scoville_num : scoville) {
            pq.add(scoville_num);
        }
        
        int answer = 0;
        
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }
            int num1 = pq.poll();
            int num2 = pq.poll();
            
            pq.add(num1 + num2 * 2);
            answer++;
        }
        
        return answer;
    }
}