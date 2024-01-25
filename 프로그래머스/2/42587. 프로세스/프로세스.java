import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int priority : priorities) {
            queue.add(priority);
        }
    
        Arrays.sort(priorities);
        
        int ind = priorities.length - 1;
        
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num != priorities[ind]) {
                queue.add(num);
            } else {
                if (location == 0) {
                    return answer;
                }
                answer++;
                ind--;
            }
            location--;
            if (location < 0) {
                location += queue.size();
            }
        }
        
        return answer;
    }
}