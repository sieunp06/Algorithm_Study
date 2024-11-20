import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char alpha : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(alpha);
                continue;
            }
            if (stack.peek() == alpha) {
                stack.pop();
                continue;
            }
            stack.push(alpha);
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}