import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {        
        PriorityQueue<Integer> processQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Process> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            processQueue.add(priorities[i]);
            q.add(new Process(i, priorities[i]));
        }
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int highestPriority = processQueue.peek();
            Process nowProcess = q.poll();
            
            if (highestPriority == nowProcess.priority) {
                processQueue.poll();
                count++;
                if (nowProcess.index == location) {
                    return count;
                }
            } else {
                q.add(nowProcess);
            }
        }
        
        return count;
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