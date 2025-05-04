import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N;
    static int[] numbers, sign;
    static int[] answer = {Integer.MIN_VALUE, Integer.MAX_VALUE};

    public static void main(String[] args) throws IOException{
        init();
        backtracking(1, numbers[0]);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];
        sign = new int[4];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            sign[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    static void backtracking(int depth, int total) {
        if (depth == N) {
            answer[0] = Math.max(answer[0], total);
            answer[1] = Math.min(answer[1], total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (sign[i] > 0) {
                sign[i]--;
                switch (i) {
                    case 0: backtracking(depth + 1, total + numbers[depth]); break;
                    case 1: backtracking(depth + 1, total - numbers[depth]); break;
                    case 2: backtracking(depth + 1, total * numbers[depth]); break;
                    case 3: backtracking(depth + 1, total / numbers[depth]); break;
                }
                sign[i]++;
            }
        }
    }
}
