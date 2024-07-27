import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char target : s.toCharArray()) {
            if (target == '(') {
                st.add(target);
                continue;
            }
            if (st.isEmpty()) {
                return false;
            }
            if (st.peek() == '(') {
                st.pop();
                continue;
            }
            return false;
        }

        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }
}