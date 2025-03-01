import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static int T, N;
//    private static int[] operators;

    private static List<Integer> operators;
    private static int[] numbers;

    private static int minAnswer;
    private static int maxAnswer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            do {
                int answer = calculate();
                minAnswer = Math.min(minAnswer, answer);
                maxAnswer = Math.max(maxAnswer, answer);
            } while (permutationOfOperators());
            stringBuilder.append("#").append(testCase).append(" ").append(maxAnswer - minAnswer).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());

        operators = new ArrayList<>();
        numbers = new int[N];

        minAnswer = Integer.MAX_VALUE;
        maxAnswer = Integer.MIN_VALUE;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            int target = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < target; j++) {
                operators.add(i);
            }
        }
        Collections.sort(operators);

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static boolean permutationOfOperators() {
        int i = operators.size() - 1;

        while (i > 0 && operators.get(i - 1) >= operators.get(i)) --i;
        if (i <= 0) return false;

        int j = operators.size() - 1;
        while (operators.get(i - 1) >= operators.get(j)) --j;

        swap(i - 1, j);
        Collections.reverse(operators.subList(i, operators.size()));

        return true;
    }

    private static void swap(int i, int j) {
        int temp = operators.get(i);
        operators.set(i, operators.get(j));
        operators.set(j, temp);
    }

    private static int calculate() {
        int answer = numbers[0];
        for (int i = 1; i < N; i++) {
            int operator = operators.get(i - 1);
            switch (operator) {
                case 0:
                    answer += numbers[i];
                    break;
                case 1:
                    answer -= numbers[i];
                    break;
                case 2:
                    answer *= numbers[i];
                    break;
                default:
                    answer /= numbers[i];
                    break;
            }
        }
        return answer;
    }
}