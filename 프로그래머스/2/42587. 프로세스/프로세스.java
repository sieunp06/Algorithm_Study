import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(new Process(i, priorities[i]));
        }
        
        while (!queue.isEmpty()) {
            int now_priority = pq.peek();
            Process p = queue.poll();
            
            if (p.priority == now_priority) {
                pq.poll();
                answer++;
                if (p.index == location) {
                    return answer;
                }
                continue;
            }
            queue.add(p);
        }
        return answer;
    }
}

class Process {
    int index;
    int priority;
    
    Process(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}