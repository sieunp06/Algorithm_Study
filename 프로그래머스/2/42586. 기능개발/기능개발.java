import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            progresses[i] = remain / speeds[i];
            if (remain % speeds[i] != 0) {
                progresses[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int progress : progresses) {
            q.add(progress);
        }
        
        int max = q.poll();
        int count = 1;
        
        while (!q.isEmpty()) {
            int num = q.poll();
            if (max < num) {
                max = num;
                list.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        
        list.add(count);
            
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}