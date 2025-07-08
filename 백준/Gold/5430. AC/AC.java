import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int n;
    static String p;
    static Deque<Integer> deque;
    static boolean reverse;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            solve();
        }
    }

    static void init() throws IOException {
        p = bufferedReader.readLine();
        n = Integer.parseInt(bufferedReader.readLine());

        deque = new ArrayDeque<>();
        String input = bufferedReader.readLine();
        String[] num = input.substring(1, input.length() - 1).split(",");

        if (n > 0) {
            for (int i = 0; i < num.length; i++) {
                deque.add(Integer.parseInt(num[i]));
            }
        }
    }

    static void solve() {
        reverse = false;
        for (char command : p.toCharArray()) {
            if (command == 'R') {
                reverse = !reverse;
            } else if (command == 'D') {
                if (deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                if (reverse) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }
        printResult();
    }

    static void printResult() {
        stringBuilder.setLength(0);
        stringBuilder.append("[");
        if (!deque.isEmpty()) {
            if (reverse) {
                Iterator<Integer> iter = deque.descendingIterator();
                stringBuilder.append(iter.next());
                while (iter.hasNext()) {
                    stringBuilder.append(",").append(iter.next());
                }
            } else {
                Iterator<Integer> iter = deque.iterator();
                stringBuilder.append(iter.next());
                while (iter.hasNext()) {
                    stringBuilder.append(",").append(iter.next());
                }
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }
}
