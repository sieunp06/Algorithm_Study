import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;

    private static Food[] foods;
    private static int min = Integer.MAX_VALUE;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        foods = new Food[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int S = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            foods[i] = new Food(S, B);
        }
        dfs(0, 0, 1, 0);
        System.out.println(min);
    }

    private static void dfs (int count, int put,  int S, int B) {
        if (count == N) {
            if (put > 0) {
                min = Math.min(min, Math.abs(S - B));
            }
            return;
        }
        dfs(count + 1, put + 1, S * foods[count].S, B + foods[count].B);
        dfs(count + 1, put, S, B);
    }
}

class Food {
    int S;
    int B;

    Food(int S, int B) {
        this.S = S;
        this.B = B;
    }
}