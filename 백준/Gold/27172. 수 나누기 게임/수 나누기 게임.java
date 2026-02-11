import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] cards = new int[N];
        int[] score = new int[1000001];
        boolean[] exists = new boolean[1000001];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(stringTokenizer.nextToken());
            exists[cards[i]] = true;
        }

        for (int i = 0; i < N; i++) {
            int x = cards[i];

            for (int multiple = x * 2; multiple <= 1000000; multiple += x) {
                if (exists[multiple]) {
                    score[x]++;
                    score[multiple]--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            stringBuilder.append(score[cards[i]]).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
