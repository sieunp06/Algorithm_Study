import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        while (N-- > 0) {
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
                stringBuilder.append("YES\n");
            } else {
                stringBuilder.append("NO\n");
            }
        }

        System.out.print(stringBuilder);
    }
}
