import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();
        int answer = 0;
        
        for (int scovilleScore: scoville) {
            scovilleQueue.add(scovilleScore);
        }
        
        while (scovilleQueue.size() > 1) {
            if (scovilleQueue.peek() >= K) {
                break;
            }
            
            int first = scovilleQueue.poll();
            int second = scovilleQueue.poll();
            int result = first + second * 2;
            scovilleQueue.add(result);
            answer++;
        }
        
        if (scovilleQueue.peek() < K) {
            return -1;
        }
        return answer;
    }
}