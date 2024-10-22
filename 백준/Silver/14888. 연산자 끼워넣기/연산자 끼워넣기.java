import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] numbers;
    static int[] types;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        types = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < types.length; i++) {
            types[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void DFS(int depth, int total) {
        if (depth == N) {
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (types[i] > 0) {
                types[i]--;

                switch (i) {
                    case 0: DFS(depth + 1, total + numbers[depth]); break;
                    case 1: DFS(depth + 1, total - numbers[depth]); break;
                    case 2: DFS(depth + 1, total * numbers[depth]); break;
                    case 3: DFS(depth + 1, total / numbers[depth]); break;
                }
                types[i]++;
            }
        }
    }
}
