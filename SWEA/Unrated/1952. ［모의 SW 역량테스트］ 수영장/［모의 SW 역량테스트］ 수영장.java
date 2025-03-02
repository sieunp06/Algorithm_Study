import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static final int NUM_OF_TICKETS = 4;
    private static final int MONTH = 12;

    private static int T;

    private static int[] tickets = new int[NUM_OF_TICKETS];
    private static int[] months = new int[MONTH + 1];

    private static int answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            find(1, 0);
            stringBuilder.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        answer = Integer.MAX_VALUE;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < NUM_OF_TICKETS; i++) {
            tickets[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= MONTH; i++) {
            months[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void find(int month, int total) {
        if (month > 12) {
            answer = Math.min(answer, total);
            return;
        }

        if (months[month] > 0) {
            find(month + 1, total + months[month] * tickets[0]);
            find(month + 1, total + tickets[1]);
            find(month + 3, total + tickets[2]);
            find(month + 12, total + tickets[3]);
        } else {
            find(month + 1, total);
        }

    }
}