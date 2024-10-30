import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] nums = new int[N + 3];
        Arrays.fill(nums, 0);

        nums[3] = 1; nums[5] = 1;

        for (int i = 6; i <= N; i++) {
            if (i % 5 == 0) {
                nums[i] = nums[i - 5] + 1;
                continue;
            }
            if (i % 3 == 0) {
                nums[i] = nums[i - 3] + 1;
                continue;
            }
            if (nums[i - 3] != 0 && nums[i - 5] != 0) {
                nums[i] = Math.min(nums[i - 3], nums[i - 5]) + 1;
            }
        }
        if (nums[N] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(nums[N]);
        }
    }
}