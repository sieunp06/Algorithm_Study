import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());

        int[] day = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int start = 0; int end = start + X - 1;
        int total = 0;
        int max = total;
        for (int i = start; i <= end; i++) {
            total += day[i];
        }

        int count = 0;
        while (end < N - 1) {
            if (max == total) {
                count++;
            } else if (max < total) {
                max = total;
                count = 1;
            }
            total -= day[start];
            start++; end++;
            total += day[end];
        }
        if (max == total) {
            count++;
        }

        if (max == 0) {
            stringBuilder.append("SAD");
        } else {
            stringBuilder.append(max).append('\n').append(count);
        }

        System.out.println(stringBuilder);
    }
}