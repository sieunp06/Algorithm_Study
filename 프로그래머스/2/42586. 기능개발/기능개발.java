import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        for (int i = progresses.length - 1; i >= 0; i--) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }
            stack.add(day);
        }
        
        List<Integer> counts = new ArrayList<>();
        int count = 0;
        int days = -1;
        while (!stack.isEmpty()) {
            int peek = stack.pop();
            if (days == -1) {
                days = peek;
                count++;
                continue;
            }
            if (peek > days) {
                counts.add(count);
                days = peek;
                count = 1;
                continue;
            }
            count++;
        }
        counts.add(count);
        
        int[] answer = new int[counts.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = counts.get(i);
        }
        return answer;
    }
}