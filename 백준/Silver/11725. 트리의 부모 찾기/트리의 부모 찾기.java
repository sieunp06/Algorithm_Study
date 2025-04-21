import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;   // 노드의 개수

    private static boolean[] visited;
    private static List<Integer>[] list;
    private static int[] answers;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        dfs(1);
        for (int i = 2; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());

        list = new List[N + 1];
        visited = new boolean[N + 1];
        answers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
    }

    private static void dfs(int target) {
        for (int num : list[target]) {
            if (num == target || visited[num]) {
                continue;
            }
            answers[num] = target;
            visited[num] = true;
            dfs(num);
        }
    }
}