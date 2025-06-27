import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr); // 정렬 필수

        int left = 0;
        int right = N - 1;
        int minDiff = Integer.MAX_VALUE;
        int answerLeft = 0;
        int answerRight = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);

            if (absSum < minDiff) {
                minDiff = absSum;
                answerLeft = arr[left];
                answerRight = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        stringBuilder.append(answerLeft).append(" ").append(answerRight);
        System.out.println(stringBuilder);
    }
}
