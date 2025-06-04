import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();

            if (command.equals("push")) {
                st.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
            if (command.equals("pop")) {
                if (st.isEmpty()) {
                    stringBuilder.append("-1").append("\n");
                    continue;
                }
                stringBuilder.append(st.pop()).append("\n");
            }
            if (command.equals("size")) {
                stringBuilder.append(st.size()).append("\n");
            }
            if (command.equals("empty")) {
                if (st.isEmpty()) {
                    stringBuilder.append(1).append("\n");
                } else {
                    stringBuilder.append(0).append("\n");
                }
            }
            if (command.equals("top")) {
                if (st.isEmpty()) {
                    stringBuilder.append(-1).append("\n");
                    continue;
                }
                stringBuilder.append(st.peek()).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
