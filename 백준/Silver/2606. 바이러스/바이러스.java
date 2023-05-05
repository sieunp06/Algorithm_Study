import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] computers;
    static boolean[] visited;

    static int numOfComputer;
    static int numOfNetworkConnectedComputer;

    static int wormedComputerCount;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numOfComputer = Integer.parseInt(bf.readLine());
        numOfNetworkConnectedComputer = Integer.parseInt(bf.readLine());

        computers = new ArrayList[numOfComputer + 1];
        visited = new boolean[numOfComputer + 1];

        for (int i = 1; i <= numOfComputer; i++) {
            computers[i] = new ArrayList<>();
        }
        for (int i = 0; i < numOfNetworkConnectedComputer; i++) {
            st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            computers[u].add(v);
            computers[v].add(u);
        }
        /**
         * 1 -> 2 5
         * 2 -> 3 5
         * 3 -> 2
         * 4 -> 7
         * 5 -> 1 2 6
         * 6 -> 5
         * 7 -> 4
         */
        wormedComputerCount = 0;

        DFS(1);

        System.out.println(wormedComputerCount - 1);
    }
    public static void DFS(int computerNum) {
        wormedComputerCount++;
        visited[computerNum] = true;

        for (int i : computers[computerNum]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}