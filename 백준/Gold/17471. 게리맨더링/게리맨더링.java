import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] population;
    private static List<Integer>[] graph;

    private static boolean[] selected;

    private static int answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        divide(0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        
        selected = new boolean[N];
        answer = Integer.MAX_VALUE;
        population = new int[N];
        graph = new List[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(stringTokenizer.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int size = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < size; j++) {
                graph[i].add(Integer.parseInt(stringTokenizer.nextToken()) - 1);
            }
        }
    }

    private static void divide(int idx) {
        if (idx == N) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    a.add(i);
                } else {
                    b.add(i);
                }
            }
            if (a.size() == 0 || b.size() == 0) {
                return;
            }
            if (check(a) && check(b)) {
                getPeopleDiff();
            }
            return;
        }

        selected[idx] = true;
        divide(idx + 1);
        selected[idx] = false;
        divide(idx + 1);

    }

    private static boolean check(List<Integer> list) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedLocal = new boolean[N];
        visitedLocal[list.get(0)] = true;
        q.offer(list.get(0));

        int count = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int neighbor : graph[cur]) {
                if (list.contains(neighbor) && !visitedLocal[neighbor]) {
                    q.offer(neighbor);
                    visitedLocal[neighbor] = true;
                    count++;
                }
            }
        }
        return count == list.size();
    }

    private static void getPeopleDiff() {
        int pA = 0, pB = 0;
        for (int i = 0; i < N; i++) {
            if (selected[i])
                pA += population[i];
            else
                pB += population[i];
        }
        int diff = Math.abs(pA - pB);
        answer = Math.min(answer, diff);
    }
}
