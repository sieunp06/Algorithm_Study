import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        while (true) {
            String input = bufferedReader.readLine();

            if (input.equals(".")) {
                break;
            }

            Stack<Character> st = new Stack<>();
            boolean isBalanced = true;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == '(' || ch == '[') {
                    st.push(ch);
                } else if (ch == ')') {
                    if (st.isEmpty() || st.peek() != '(') {
                        isBalanced = false;
                        break;
                    }
                    st.pop();
                } else if (ch == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        isBalanced = false;
                        break;
                    }
                    st.pop();
                }
            }

            if (isBalanced && st.isEmpty()) {
                stringBuilder.append("yes\n");
            } else {
                stringBuilder.append("no\n");
            }
        }

        System.out.print(stringBuilder);
    }
}
