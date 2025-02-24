import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int numOfComputer;
    private static int numOfpairComputer;

    private static boolean[] visited;
    private static List<Integer>[] computers;

    private static int answer = 0;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        dfs(1);
        System.out.println(answer - 1);
    }

    private static void init() throws IOException {
        numOfComputer = Integer.parseInt(bufferedReader.readLine());
        numOfpairComputer = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[numOfComputer + 1];
        computers = new List[numOfComputer + 1];
        for (int i = 1; i <= numOfComputer; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < numOfpairComputer; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            computers[a].add(b);
            computers[b].add(a);
        }
    }

    private static void dfs(int num) {
        answer++;
        visited[num] = true;

        for (int i : computers[num]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
