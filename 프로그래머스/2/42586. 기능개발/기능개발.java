import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }
            
            q.add(day);
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        int preDay = q.poll();
        int count = 1;
        while (!q.isEmpty()) {
            if (q.peek() <= preDay) {
                q.poll();
                count++;
            } else {
                preDay = q.peek();
                answerList.add(count);
                count = 0;
            }
        }
        
        answerList.add(count);
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}