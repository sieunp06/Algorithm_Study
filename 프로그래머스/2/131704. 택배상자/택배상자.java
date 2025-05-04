import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int answer = 0;

        for (int i = 1; i <= order.length; i++) {
            if (order[idx] == i) {
                answer++;
                idx++;
            } else {
                stack.push(i);
            }

            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                answer++;
                idx++;
            }
        }

        return answer;
    }
}
