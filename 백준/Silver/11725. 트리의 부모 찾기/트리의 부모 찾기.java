import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visited;
    private static int[] answer;
    private static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        answer = new int[N + 1];
        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void dfs(int target) {
        visited[target] = true;
        for (int num : list[target]) {
            if (!visited[num]) {
                answer[num] = target;
                dfs(num);
            }
        }
    }
}