import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = bufferedReader.readLine();
        String line2 = bufferedReader.readLine();

        int[][] dp = new int[line1.length() + 1][line2.length() + 2];

        for (int i = 1; i <= line1.length(); i++) {
            for (int j = 1; j <= line2.length(); j++) {
                if (line1.charAt(i - 1) == line2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[line1.length()][line2.length()]);
    }
}
