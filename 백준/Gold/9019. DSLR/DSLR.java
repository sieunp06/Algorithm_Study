import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int T;
    static int A, B;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            init();
            solve();
        }
        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        A = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());
    }

    static void solve() {
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        queue.offer(new Pair(A, ""));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int num = current.num;
            String command = current.command;

            if (num == B) {
                stringBuilder.append(command).append("\n");
                return;
            }

            // D
            int next = (num * 2) % 10000;
            if (!visited[next]) {
                visited[next] = true;
                queue.offer(new Pair(next, command + "D"));
            }

            // S
            next = (num == 0) ? 9999 : num - 1;
            if (!visited[next]) {
                visited[next] = true;
                queue.offer(new Pair(next, command + "S"));
            }

            // L
            next = (num % 1000) * 10 + num / 1000;
            if (!visited[next]) {
                visited[next] = true;
                queue.offer(new Pair(next, command + "L"));
            }

            // R
            next = (num % 10) * 1000 + num / 10;
            if (!visited[next]) {
                visited[next] = true;
                queue.offer(new Pair(next, command + "R"));
            }
        }
    }

    static class Pair {
        int num;
        String command;

        Pair(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }
}
