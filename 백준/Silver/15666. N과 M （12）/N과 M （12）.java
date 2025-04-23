import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder;
    static StringTokenizer stringTokenizer;

    static int N, M;
    static int[] numbers, answer;
    static Set<String> answerSet;

    public static void main(String[] args) throws IOException {
        init();
        combination(0, 0);
        print();
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N];
        answer = new int[M];

        answerSet = new TreeSet<>((s1, s2) -> {
            String[] a1 = s1.trim().split(" ");
            String[] a2 = s2.trim().split(" ");
            for (int i = 0; i < a1.length; i++) {
                int diff = Integer.parseInt(a1[i]) - Integer.parseInt(a2[i]);
                if (diff != 0) return Integer.parseInt(a1[i]) - Integer.parseInt(a2[i]);
            }
            return 0;
        });

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(numbers);
    }

    static void combination(int start, int depth) {
        if (depth == M) {
            Arrays.sort(answer);
            printResult();
            return;
        }

        for (int i = start; i < N; i++) {
            answer[depth] = numbers[i];
            combination(i, depth + 1);
        }
    }

    static void printResult() {
        stringBuilder = new StringBuilder();
        for (int num : answer) {
            stringBuilder.append(num).append(" ");
        }
        stringBuilder.append("\n");
        answerSet.add(stringBuilder.toString());
    }

    static void print() {
        for (String answer : answerSet) {
            System.out.print(answer);
        }
    }
}