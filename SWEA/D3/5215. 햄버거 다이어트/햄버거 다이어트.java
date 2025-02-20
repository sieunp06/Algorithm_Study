import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    private static int T;
    private static int N;   // 재료의 수
    private static int L;   // 제한 칼로리

    private static Food[] foods;

    private static int max;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            dfs(foods, 0, 0, 0);
            stringBuilder.append("#").append(testCase).append(" ").append(max).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        L = Integer.parseInt(stringTokenizer.nextToken());

        foods = new Food[N];

        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int score = Integer.parseInt(stringTokenizer.nextToken());
            int calories = Integer.parseInt(stringTokenizer.nextToken());

            foods[i] = new Food(score, calories);
        }
    }

    private static void dfs(Food[] foods, int depth, int totalCalories, int totalScore) {
        if (totalCalories > L) {
            return;
        }
        if (depth == N) {
            max = Math.max(max, totalScore);
            return;
        }
        max = Math.max(max, totalScore);
        dfs(foods, depth + 1, totalCalories + foods[depth].calories, totalScore + foods[depth].score);
        dfs(foods, depth + 1, totalCalories, totalScore);
    }
}

class Food {
    int score;
    int calories;

    Food(int score, int calories) {
        this.score = score;
        this.calories = calories;
    }
}
