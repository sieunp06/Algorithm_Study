import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int numOfComputer, pairOfComputer;
    static List<Integer>[] computers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs(1));
    }

    static void init() throws IOException {
        numOfComputer = Integer.parseInt(bufferedReader.readLine());
        pairOfComputer = Integer.parseInt(bufferedReader.readLine());

        computers = new List[numOfComputer + 1];
        visited = new boolean[numOfComputer + 1];

        for (int i = 1; i <= numOfComputer; i++) {
            computers[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < pairOfComputer; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            computers[a].add(b);
            computers[b].add(a);
        }
    }

    private static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int num : computers[now]) {
                if (!visited[num]) {
                    q.add(num);
                    visited[num] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
