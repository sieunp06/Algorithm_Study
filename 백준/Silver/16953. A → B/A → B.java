import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder;
    static StringTokenizer stringTokenizer;

    static int A, B;
    static int answer;

    static class Node {
        long num;
        int count;

        Node(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        A = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());

        answer = Integer.MAX_VALUE;
    }

    static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(A, 1));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            long num = now.num;
            int count = now.count;

            if (num > B) continue;
            if (num == B) {
                answer = Math.min(answer, count);
                continue;
            }

            queue.add(new Node(num * 2, count + 1));
            queue.add(new Node(num * 10 + 1, count + 1));
        }
    }
}