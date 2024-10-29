import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        int[] coins = new int[n];
        int[] nums = new int[k + 1];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }
        nums[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= coins[i]) {
                    nums[j] += nums[j - coins[i]];
                }
            }
        }
        System.out.println(nums[k]);
    }
}