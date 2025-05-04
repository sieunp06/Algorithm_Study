import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] answer;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException{
        init();
        solve(0);
        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        answer = new int[M];
    }

    static void solve(int depth) {
        if (depth == M) {
            printResult();
            return;
        }

        for (int i = 1; i <= N; i++) {
            answer[depth] = i;
            solve(depth + 1);
        }
    }

    static void printResult() {
        for (int i = 0; i < M; i++) {
            stringBuilder.append(answer[i]).append(" ");
        }
        stringBuilder.append("\n");
    }
}
