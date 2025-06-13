import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, M;
    static Map<Integer, Boolean> cardMap;

    public static void main(String[] args) throws IOException {
        init();
        checkCards();
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        cardMap = new HashMap<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(stringTokenizer.nextToken());
            cardMap.put(card, true);
        }

        M = Integer.parseInt(bufferedReader.readLine());
    }

    private static void checkCards() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(cardMap.containsKey(query) ? "1 " : "0 ");
        }
    }
}
