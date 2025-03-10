import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] cards, target;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        for (int num : target) {
            stringBuilder.append(search_down(num) - search_up(num)).append(" ");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        cards = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(cards);

        M = Integer.parseInt(bufferedReader.readLine());
        target = new int[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static int search_down(int num) {
        int left = 0; int right = N;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (num < cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int search_up(int num) {
        int left = 0; int right = N;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (num <= cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}