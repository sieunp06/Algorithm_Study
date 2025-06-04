import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        while (dq.size() >= 2) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());

            if (dq.size() == 1) {
                break;
            }
        }
        System.out.println(dq.poll());
    }
}
