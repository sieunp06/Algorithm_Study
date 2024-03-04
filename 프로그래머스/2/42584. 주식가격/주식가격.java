import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<>();
        
        for (int price: prices) {
            q.add(price);
        }
        
        int index = 0;
        while (!q.isEmpty()) {
            int num = q.poll();
            
            for (int qNum: q) {
                answer[index]++;
                if (num > qNum) {
                    break;
                }
            }
            index++;
        }
        
        return answer;
    }
}