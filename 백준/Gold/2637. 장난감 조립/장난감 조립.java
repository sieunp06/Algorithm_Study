import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;

    private static List<Node>[] graph;
    private static int[] inDegree;

    private static int[] answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        topologySort();
        printAnswer();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());    // 완제품 번호
        M = Integer.parseInt(bufferedReader.readLine());

        graph = new List[N + 1];
        inDegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        answer = new int[N + 1];
        answer[N] = 1;

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int X = Integer.parseInt(stringTokenizer.nextToken());  // 중간 부품이나 완제품 X를 만드는 데
            int Y = Integer.parseInt(stringTokenizer.nextToken());  // 중간 부품이나 기본 부품 Y가
            int K = Integer.parseInt(stringTokenizer.nextToken());  // K개 필요하다.

            graph[X].add(new Node(Y, K));
            inDegree[Y]++;
        }
    }

    private static void topologySort() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node node : graph[now]) {
                inDegree[node.index]--;
                answer[node.index] += node.num * answer[now];
                if (inDegree[node.index] == 0) {
                    queue.offer(node.index);
                }
            }
        }
    }

    private static void printAnswer() {
        for (int i = 1; i <= N; i++) {
            if (graph[i].isEmpty()) {
                System.out.println(i + " " + answer[i]);
            }
        }
    }
}

class Node {
    int index;
    int num;

    Node(int index, int num) {
        this.index = index;
        this.num = num;
    }
}