import java.util.Stack;

class Solution {
    final char LEFT = '(';
    final char RIGHT = ')';
    
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        
        for (char alpha: s.toCharArray()) {
            if (alpha == RIGHT) {
                if (st.isEmpty()) {
                    return false;
                }
                if (st.peek() != LEFT) {
                    return false;
                } else {
                    st.pop();
                }
            } else {
                st.push(alpha);
            }
        }
        
        if (!st.isEmpty()) {
            return false;
        }

        return answer;
    }
}