import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Stack<Character> stack = new Stack<>();

        int total = 0;
        for (char i : input.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(i);
                total += 10;
                continue;
            }
            if (stack.peek() == i) {
                total += 5;
            } else {
                total += 10;
            }
            stack.add(i);
        }

        System.out.println(total);
    }
}
