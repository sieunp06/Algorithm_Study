import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    final String INSERT = "I";
    
    public int[] solution(String[] operations) {
        StringTokenizer st;
        
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation: operations) {
            st = new StringTokenizer(operation);
            
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (isInsert(command)) {
                minQueue.add(num);
                maxQueue.add(num);
            } else {
                if (maxQueue.isEmpty()) {
                    continue;
                }
                if (num == 1) {
                    int deletedNum = maxQueue.poll();
                    minQueue.remove(deletedNum);
                } else {
                    int deletedNum = minQueue.poll();
                    maxQueue.remove(deletedNum);
                }
            }
        }
        
        if (!maxQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
        return answer;
    }
    
    private boolean isInsert(String command) {
        if (command.equals(INSERT)) {
            return true;
        }
        return false;
    }
}