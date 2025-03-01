import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static int T, N;
    private static int[][] foods;
    private static boolean[] isSelected;

    private static int answer;
    
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            combinationOfFood(0, 0);
            stringBuilder.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        foods = new int[N][N];
        isSelected = new boolean[N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                foods[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void combinationOfFood(int idx, int cnt) {
        if (cnt == N / 2) {
            answer = Math.min(answer, countScore());
            return;
        }

        for (int i = idx; i < N; i++) {
            isSelected[i] = true;
            combinationOfFood(i + 1, cnt + 1);
            isSelected[i] = false;
        }
    }

    private static int countScore() {
        int A = 0;
        int B = 0;

        for (int i = 0; i < isSelected.length; i++) {
            for (int j = i + 1; j < isSelected.length; j++) {
                if (isSelected[i] && isSelected[j]) {
                    A += foods[i][j] + foods[j][i];
                }
                if (!isSelected[i] && !isSelected[j]) {
                    B += foods[i][j] + foods[j][i];
                }
            }
        }

        return Math.abs(A - B);
    }
}