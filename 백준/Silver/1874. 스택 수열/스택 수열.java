import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        int current = 1;
        boolean isPossible = true;

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(bufferedReader.readLine());

            while (current <= target) {
                stack.push(current++);
                stringBuilder.append("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                stringBuilder.append("-\n");
            } else {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.print(stringBuilder);
        } else {
            System.out.println("NO");
        }
    }
}
