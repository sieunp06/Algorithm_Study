import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        
        while (i < arr.length) {
            if (stk.isEmpty()) {
                stk.push(arr[i]);
            } else if (stk.peek() == arr[i]) {
                stk.pop();
            } else {
                stk.push(arr[i]);
            }
            i++;
        }
        
        if (stk.isEmpty()) {
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[stk.size()];
        
        for (int j = 0; j < stk.size(); j++) {
            answer[j] = stk.get(j);
        
        }        
        return answer;
    }
}