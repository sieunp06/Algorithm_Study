import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char target = line.charAt(i);

            if (target >= 'A' && target <= 'Z') {
                stringBuilder.append(target);
            } else if (target == '(') {
                stack.push(target);
            } else if (target ==')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stringBuilder.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(target)) {
                    stringBuilder.append(stack.pop());
                }
                stack.push(target);
            }
        }

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder);
    }

    private static int getPriority(char operator) {
        if (operator == '-' || operator == '+') return 1;
        if (operator == '*' || operator == '/') return 2;
        return 0;
    }
}
