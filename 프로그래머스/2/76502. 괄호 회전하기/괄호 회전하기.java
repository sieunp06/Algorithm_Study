import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String change = s;
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> st = new Stack<>();
            StringBuilder sb = new StringBuilder(change);
            boolean flag = true;
            for (int j = 0; j < change.length(); j++) {
                char alpha = change.charAt(j);
                if (alpha == ')') {
                    if (st.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (st.peek() == '(') {
                        st.pop();
                    }
                } else if (alpha == ']') {
                    if (st.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (st.peek() == '[') {
                        st.pop();
                    }
                } else if (alpha == '}') {
                    if (st.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (st.peek() == '{') {
                        st.pop();
                    }
                } else {
                    st.push(alpha);
                }
            }
            if (!st.isEmpty()) {
                flag = false;
            }
            if (flag) {
                answer++;
            }
            change = sb.substring(1, s.length());
            change += sb.substring(0, 1);
        }
        
        return answer;
    }
}