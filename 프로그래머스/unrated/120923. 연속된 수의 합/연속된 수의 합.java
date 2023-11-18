import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public Deque<Integer> solution(int num, int total) {
        Deque<Integer> answer = new LinkedList<>();
        
        int start = 1;
        int end = start + num - 1;
        int total_num = 0;
        
        for (int i = start; i <= end; i++) {
            answer.add(i);
            total_num += i;
        }
        
        while (total_num != total) {
            if (total_num < total) {
                total_num -= start;
                answer.pollFirst();
                start++; end++;
                answer.addLast(end);
                total_num += end;
            } else {
                total_num -= end;
                answer.pollLast();
                end--; start--;
                answer.addFirst(start);
                total_num += start;
            }
        }
        
        return answer;
    }
}