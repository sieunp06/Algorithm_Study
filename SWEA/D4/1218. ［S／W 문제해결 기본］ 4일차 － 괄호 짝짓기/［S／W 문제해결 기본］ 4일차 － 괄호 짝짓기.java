import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    private static int T = 10;
    private static Stack<Character> stack;
    private static int len;
    private static String input;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            stringBuilder.append("#").append(testCase).append(" ").append(result() ? 1 : 0).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        len = Integer.parseInt(bufferedReader.readLine());
        stack = new Stack<>();
        input = bufferedReader.readLine();
    }

    private static boolean result() {
        for (int i = 0; i < len; i++) {
            char target = input.charAt(i);
            if (stack.isEmpty()) {
                stack.add(target);
                continue;
            }
            if (stack.peek() == '(') {
                if (target == ')') {
                    stack.pop();
                    continue;
                }
                if (target == ']' || target == '}' || target == '>') {
                    return false;
                }
            }
            if (stack.peek() == '[') {
                if (target == ']') {
                    stack.pop();
                    continue;
                }
                if (target == ')' || target == '}' || target == '>') {
                    return false;
                }
            }
            if (stack.peek() == '{') {
                if (target == '}') {
                    stack.pop();
                    continue;
                }
                if (target == ')' || target == ']' || target == '>') {
                    return false;
                }
            }
            if (stack.peek() == '<') {
                if (target == '>') {
                    stack.pop();
                    continue;
                }
                if (target == ')' || target == ']' || target == '}') {
                    return false;
                }
            }
            stack.add(target);
        }
        return true;
    }
}
