import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    private static final int NUM_OF_CARDS = 18;

    private static int T;   // 테스트케이스 개수
    private static int[] cards;
    private static int[] selectedCards;
    private static boolean[] isSelected;

    private static int[] result;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            permutation(0);
            stringBuilder.append("#").append(testCase).append(" ").append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        cards = new int[9];
        selectedCards = new int[9];
        isSelected = new boolean[NUM_OF_CARDS + 1];
        result = new int[2];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            cards[i] = num;
            isSelected[num] = true;
        }
    }

    private static void permutation(int depth) {
        if (depth == 9) {
            game();
            return;
        }

        for (int i = 1; i <= NUM_OF_CARDS; i++) {
            if (isSelected[i]) {
                continue;
            }
            selectedCards[depth] = i;
            isSelected[i] = true;
            permutation(depth + 1);
            isSelected[i] = false;
        }
    }

    private static void game() {
        long[] scores = new long[2];  // 0: 규영이 점수, 1: 인영이 점수

        for (int i = 0; i < cards.length; i++) {
            if (selectedCards[i] < cards[i]) {  // 규영 승
                scores[0] += selectedCards[i] + cards[i];
            } else {
                scores[1] += selectedCards[i] + cards[i];
            }
        }
        if (scores[0] > scores[1]) {
            result[0]++;
        } else {
            result[1]++;
        }
    }
}
