import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    private static int T; // 테스트케이스 개수
    private static int N;
    private static int M;

    private static List<Integer> bannedIngredients;

    private static int answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init();
//            for (int i = 0; i <= N; i++) {
//                subset(1, 0, i);
//            }
            masking();
            stringBuilder.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());  // 재료의 수
        M = Integer.parseInt(stringTokenizer.nextToken());

        bannedIngredients = new ArrayList<>();

        answer = 0;

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            bannedIngredients.add((1 << a) | (1 << b));
        }
    }

    private static void masking() {
        for (int mask = 0; mask < (1 << N); mask++) {
            if (!isIngredientsContains(mask)) {
                answer++;
            }
        }
    }

//    private static void subset(int idx, int count, int target) {
//        if (count == target) {
//            containsIngredients = new ArrayList<>();
//            for (int i = 1; i <= N; i++) {
//                if (isSelected[i]) {
//                    containsIngredients.add(i);
//                }
//            }
//
//            if (!isIngredientsContains(containsIngredients)) {
//                answer++;
//            }
//            return;
//        }
//
//        if (idx > N) {
//            return;
//        }
//
//        isSelected[idx] = true;
//        subset(idx + 1, count + 1, target);
//        isSelected[idx] = false;
//        subset(idx + 1, count, target);
//    }

    private static boolean isIngredientsContains(int mask) {
        for (int banned : bannedIngredients) {
            if ((mask & banned) == banned) {
                return true;
            }
        }
        return false;
    }
}
