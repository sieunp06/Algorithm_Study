import java.util.Stack;

class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        
        if (arr[0] == ')') return false;
        
        for (char alpha: arr) {
            if (alpha == '(') st.push(alpha);
            else {
                if (st.isEmpty()) return false;
                else st.pop();
            }
        }
        return st.isEmpty();
    }
}