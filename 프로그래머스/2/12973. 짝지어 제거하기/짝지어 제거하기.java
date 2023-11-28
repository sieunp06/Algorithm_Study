import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char alpha : s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(alpha);
            } else {
                if (st.peek() == alpha) {
                    st.pop();
                } else {
                    st.push(alpha);
                }
            }
        }
        
        if (st.isEmpty()) {
            return 1;
        }
        return 0;
    }
}