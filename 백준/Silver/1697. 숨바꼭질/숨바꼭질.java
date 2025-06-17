import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] isVisited;
    static final int MAX = 100_001;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        isVisited = new boolean[100001];
    }

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {N, 0});
        isVisited[N] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == K) {
                return now[1];
            }

            int[] next = {now[0] - 1, now[0] + 1, now[0] * 2};
            for (int position : next) {
                if (position >= 0 && position < MAX && !isVisited[position]) {
                    isVisited[position] = true;
                    queue.add(new int[]{position, now[1] + 1});
                }
            }
        }
        return -1;
    }
}