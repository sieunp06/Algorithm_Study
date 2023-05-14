import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {         // 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (command == 2) {  // 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                if (!stack.isEmpty()) sb.append(stack.pop()).append('\n');
                else sb.append(-1).append('\n');
            } else if (command == 3) {  // 3: 스택에 들어있는 정수의 개수를 출력한다.
                sb.append(stack.size()).append('\n');
            } else if (command == 4) {  // 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
                if (stack.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else {                    // 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                if (!stack.isEmpty()) sb.append(stack.peek()).append('\n');
                else sb.append(-1).append('\n');
            }
        }
        System.out.println(sb);
    }
}
