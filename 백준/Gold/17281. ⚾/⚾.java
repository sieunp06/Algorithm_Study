import java.io.*;
import java.util.*;

public class Main {
    private static final int NUM_OF_PLAYER = 9;
    private static int N;
    private static int[][] innings;
    private static int maxScore = 0;

    public static void main(String[] args) throws IOException {
        init(new BufferedReader(new InputStreamReader(System.in)));

        List<Integer> lineup = new ArrayList<>();
        for (int i = 1; i < 9; i++) lineup.add(i);

        do {
            int[] order = new int[NUM_OF_PLAYER];
            for (int i = 0, j = 0; i < NUM_OF_PLAYER; i++) {
                if (i == 3) order[i] = 0;
                else order[i] = lineup.get(j++);
            }
            maxScore = Math.max(maxScore, playGame(order));
        } while (nextPermutation(lineup));

        System.out.println(maxScore);
    }

    private static void init(BufferedReader bufferedReader) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        innings = new int[N][NUM_OF_PLAYER];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < NUM_OF_PLAYER; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean nextPermutation(List<Integer> arr) {
        int i = arr.size() - 1;
        while (i > 0 && arr.get(i - 1) >= arr.get(i)) i--;
        if (i == 0) return false;

        int j = arr.size() - 1;
        while (arr.get(i - 1) >= arr.get(j)) j--;

        Collections.swap(arr, i - 1, j);
        Collections.reverse(arr.subList(i, arr.size()));
        return true;
    }

    private static int playGame(int[] order) {
        int score = 0;
        int lastPlayer = 0;

        for (int inning = 0; inning < N; inning++) {
            int outCount = 0;
            int base = 0;

            while (outCount < 3) {
                int player = order[lastPlayer];
                int result = innings[inning][player];

                if (result == 0) {
                    outCount++;
                } else {
                    base = (base << result) | (1 << (result - 1));
                    score += Integer.bitCount(base >> 3);
                    base &= 7;
                }

                lastPlayer = (lastPlayer + 1) % NUM_OF_PLAYER;
            }
        }

        return score;
    }
}
